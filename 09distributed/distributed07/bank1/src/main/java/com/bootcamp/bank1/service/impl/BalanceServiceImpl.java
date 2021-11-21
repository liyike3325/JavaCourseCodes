package com.bootcamp.bank1.service.impl;

import com.bootcamp.bank.service.Bank2AccountInfoService;
import com.bootcamp.bank.service.Bank2BalanceService;
import com.bootcamp.bank1.entity.Balance;
import com.bootcamp.bank1.entity.LocalCancelLog;
import com.bootcamp.bank1.entity.LocalTryLog;
import com.bootcamp.bank1.mapper.*;
import com.bootcamp.bank1.service.BalanceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.dromara.hmily.annotation.Hmily;
import org.dromara.hmily.core.concurrent.threadlocal.HmilyTransactionContextLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Slf4j
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    LocalTryLogMapper localTryLogMapper;

    @Autowired
    LocalConfirmLogMapper localConfirmLogMapper;

    @Autowired
    LocalCancelLogMapper localCancelLogMapper;

    @Autowired
    BalanceMapper balanceMapper;

    @DubboReference(version = "1.0.0", url = "dubbo://127.0.0.1:12345")
    Bank2BalanceService bank2BalanceService;

    /**
     * 美元兑换人民币
     * @param accountNo
     * @param rmb
     */
    @Override
    @Hmily(confirmMethod = "commit", cancelMethod = "rollback")
    public void dollarExchangeRmb(String accountNo, Double rmb) {
        // 获取全局事务id
        String transId = HmilyTransactionContextLocal.getInstance().get().getTransId();
        log.info("bank1 try again 开始执行...xid:{}", transId);
        // 幂等判断 判断local_try_log表中是否有try日志记录，如果有则不再执行
        if (localTryLogMapper.isExistTry(transId) > 0) {
            log.info("bank1 try 已经执行，无需重复执行，xid:{}", transId);
            return;
        }
        // try悬挂处理，如果confirm、cancel有一个已经执行了，try不再执行
        if (localConfirmLogMapper.isExistConfirm(transId) > 0 ||
            localCancelLogMapper.isExistCancel(transId) > 0) {
            log.info("bank1 try 悬挂处理，confirm或cancel已经执行，不允许执行try，xid:{}", transId);
            return;
        }

        // 需要扣除多少美元
        double dollar = Math.round(rmb / (1 / 7) * 100) / 100;
        // 获取A余额
        Balance balance = balanceMapper.getBalanceByAccountNo(accountNo);
        if (balance.getDollar().doubleValue() < dollar) {
            throw new RuntimeException("美元不足");
        }
        // A扣除美元
        balanceMapper.subtractDollar(accountNo, dollar);
        // A增加冻结美元
        balanceMapper.addFrozenDollar(accountNo, dollar);

        // 插入try执行记录，用于幂等判断
        LocalTryLog localTryLog = new LocalTryLog();
        localTryLog.setTxNo(transId);
        localTryLog.setCreateTime(new Date());
        localTryLogMapper.insert(localTryLog);

        // 远程调用B兑换人民币
        if(!bank2BalanceService.dollarExchangeRmb("2", dollar, rmb)){
            throw new RuntimeException("bank1 远程调用李四微服务失败,xid:{}"+transId);
        }

        if (rmb == 2) {
            throw new RuntimeException("人为制造异常，xid:{}" + transId);
        }
        log.info("bank1 try end 结束执行...xid:{}", transId);
    }

    /**
     * confirm方法
     * @param accountNo
     * @param amount
     */
    @Transactional
    public void commit(String accountNo, Double amount) {
        // 获取全局事务id
        String transId = HmilyTransactionContextLocal.getInstance().get().getTransId();
        log.info("bank1 confirm begin 开始执行...xid:{},accountNo:{},amount:{}", transId, accountNo, amount);
    }

    /**
     * cancel方法
     * cancel幂等校验
     * cancel空回滚处理
     * 增加可用余额
     * @param accountNo
     * @param amount
     */
    public void rollback(String accountNo, Double amount) {
        // 获取全局事务id
        String transId = HmilyTransactionContextLocal.getInstance().get().getTransId();
        log.info("bank1 cancel begin 开始执行...xid:{}", transId);
        // cancel幂等校验
        if (localCancelLogMapper.isExistCancel(transId) > 0) {
            log.info("bank1 cancel 已经执行，无需重复执行，xid:{}", transId);
            return;
        }
        // cancel空回滚处理，如果try没有执行，cancel不允许执行
        if (localTryLogMapper.isExistTry(transId) <= 0) {
            log.info("bank1 空回滚处理，try没有执行，不允许cancel执行，xid:{}", transId);
            return;
        }
        // 增加可用余额
        accountInfoMapper.addAccountBalance(accountNo, amount);
        // 插入一条cancel的执行记录
        LocalCancelLog localCancelLog = new LocalCancelLog();
        localCancelLog.setTxNo(transId);
        localCancelLog.setCreateTime(new Date());
        localCancelLogMapper.insert(localCancelLog);
        log.info("bank1 cancel end 结束执行...xid:{}", transId);
    }
}
