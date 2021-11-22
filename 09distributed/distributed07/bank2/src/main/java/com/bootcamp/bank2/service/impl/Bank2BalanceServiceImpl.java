package com.bootcamp.bank2.service.impl;

import com.bootcamp.bank.service.Bank2BalanceService;
import com.bootcamp.bank2.entity.Balance;
import com.bootcamp.bank2.entity.LocalConfirmLog;
import com.bootcamp.bank2.entity.LocalTryLog;
import com.bootcamp.bank2.mapper.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.dromara.hmily.annotation.Hmily;
import org.dromara.hmily.core.concurrent.threadlocal.HmilyTransactionContextLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@DubboService(version = "1.0.0")
@Slf4j
public class Bank2BalanceServiceImpl implements Bank2BalanceService {

    @Autowired
    LocalTryLogMapper localTryLogMapper;

    @Autowired
    LocalConfirmLogMapper localConfirmLogMapper;

    @Autowired
    LocalCancelLogMapper localCancelLogMapper;

    @Autowired
    BalanceMapper balanceMapper;

    /**
     * 美元兑换人民币
     * @param accountNo
     * @param dollar
     * @param rmb
     * @return
     */
    @Override
    @Hmily(confirmMethod = "confirmMethod", cancelMethod = "cancelMethod")
    public Boolean dollarExchangeRmb(String accountNo, Double dollar, Double rmb) {
        // 获取全局事务id
        String transId = HmilyTransactionContextLocal.getInstance().get().getTransId();
        log.info("bank2 try again 开始执行...xid:{}", transId);
        // 幂等判断 判断local_try_log表中是否有try日志记录，如果有则不再执行
        if (localTryLogMapper.isExistTry(transId) > 0) {
            log.info("bank2 try 已经执行，无需重复执行，xid:{}", transId);
            return false;
        }
        // try悬挂处理，如果confirm、cancel有一个已经执行了，try不再执行
        if (localConfirmLogMapper.isExistConfirm(transId) > 0 ||
                localCancelLogMapper.isExistCancel(transId) > 0) {
            log.info("bank2 try 悬挂处理，confirm或cancel已经执行，不允许执行try，xid:{}", transId);
            return false;
        }

        // 获取B余额
        Balance balance = balanceMapper.getBalanceByAccountNo(accountNo);
        if (balance.getRmb().doubleValue() < rmb) {
            throw new RuntimeException("人民币不足");
        }
        // B扣除人民币
        balanceMapper.subtractRmb(accountNo, rmb);
        // B增加冻结人民币
        balanceMapper.addFrozenRmb(accountNo, rmb);

        // 插入try执行记录，用于幂等判断
        LocalTryLog localTryLog = new LocalTryLog();
        localTryLog.setTxNo(transId);
        localTryLog.setCreateTime(new Date());
        localTryLogMapper.insert(localTryLog);
        log.info("bank2 try end 结束执行...xid:{}", transId);
        return true;
    }

    public void confirmMethod(String accountNo, Double dollar, Double rmb) {
        // 获取全局事务id
        String transId = HmilyTransactionContextLocal.getInstance().get().getTransId();
        log.info("bank2 confirm begin 开始执行...xid:{}", transId);
        if (localConfirmLogMapper.isExistConfirm(transId) > 0) {
            log.info("bank2 confirm 已经执行，无需重复执行...xid:{}", transId);
            return;
        }

        // B增加美元
        balanceMapper.addDollar(accountNo, dollar);
        // B减少冻结人民币
        balanceMapper.subtractFrozenRmb(accountNo, rmb);

        // 增加一条confirm日志，用于幂等
        LocalConfirmLog localConfirmLog = new LocalConfirmLog();
        localConfirmLog.setTxNo(transId);
        localConfirmLog.setCreateTime(new Date());
        localConfirmLogMapper.insert(localConfirmLog);
        log.info("bank2 confirm end 结束执行...xid:{}", transId);
    }

    public void cancelMethod(String accountNo, Double dollar, Double rmb) {
        // 获取全局事务id
        String transId = HmilyTransactionContextLocal.getInstance().get().getTransId();
        log.info("bank2 cancel begin 开始执行...xid:{}", transId);
        // B增加人民币
        balanceMapper.addRmb(accountNo, rmb);
        // B减少冻结人民币
        balanceMapper.subtractFrozenRmb(accountNo, rmb);
    }

    public String hello() {
        return "hello";
    }
}
