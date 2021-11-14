package com.bootcamp.bank1.service.impl;

import com.bootcamp.bank1.entity.LocalCancelLog;
import com.bootcamp.bank1.entity.LocalTryLog;
import com.bootcamp.bank1.mapper.AccountInfoMapper;
import com.bootcamp.bank1.mapper.LocalCancelLogMapper;
import com.bootcamp.bank1.mapper.LocalConfirmLogMapper;
import com.bootcamp.bank1.mapper.LocalTryLogMapper;
import com.bootcamp.bank1.service.AccountInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.dromara.hmily.annotation.HmilyTCC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import com.bootcamp.bank2.service.Bank2AccountInfoService;

@Service
@Slf4j
public class AccountInfoServiceImpl implements AccountInfoService {

    @Autowired
    LocalTryLogMapper localTryLogMapper;

    @Autowired
    LocalConfirmLogMapper localConfirmLogMapper;

    @Autowired
    LocalCancelLogMapper localCancelLogMapper;

    @Autowired
    AccountInfoMapper accountInfoMapper;

    @DubboReference
    Bank2AccountInfoService bank2AccountInfoService;

    /**
     * try幂等校验
     * try悬挂处理
     * 检查余额是否足够
     * 扣减金额
     * @param accountNo
     * @param amount
     */
    @Override
    @Transactional
    @HmilyTCC(confirmMethod = "commit", cancelMethod = "rollback")
    public void updateAccountBalance(String accountNo, Double amount) {
        // 获取全局事务id
//        String transId = HmilyTransactionContextLocal.getInstance().get().getTransId();
        String transId = "1";
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

        // 扣减金额
        if (accountInfoMapper.subtractAccountBalance(accountNo, amount) <= 0) {
            // 扣减失败
            throw new RuntimeException("bank1 try 扣减金额失败，xid:{}" + transId);
        }
        // 插入try执行记录，用于幂等判断
        LocalTryLog localTryLog = new LocalTryLog();
        localTryLog.setTxNo(transId);
        localTryLog.setCreateTime(new Date());
        localTryLogMapper.insert(localTryLog);


        if (amount == 2) {
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
//        String transId = HmilyTransactionContextLocal.getInstance().get().getTransId();
        String transId = "1";
        log.info("bank1 confirm begin 开始执行...xid:{},accountNo:{},amount:{}", transId, accountNo, amount);
    }

    public void rollback(String accountNo, Double amount) {
        // 获取全局事务id
//        String transId = HmilyTransactionContextLocal.getInstance().get().getTransId();
        String transId = "1";
        log.info("bank1 cancel begin 开始执行...xid:{}", transId);
        // cancel幂等校验
        if (localCancelLogMapper.isExistCancel(transId) > 0) {
            log.info("bank1 cancel 已经执行，无需重复执行，xid:{}", transId);
            return;
        }
        // cancel空回滚处理，如果try没有执行，cancel不允许执行
        if (localCancelLogMapper.isExistCancel(transId) <= 0) {
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
