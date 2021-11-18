package com.bootcamp.bank2.service.impl;

import com.bootcamp.bank.service.Bank2AccountInfoService;
import com.bootcamp.bank2.entity.LocalConfirmLog;
import com.bootcamp.bank2.mapper.AccountInfoMapper;
import com.bootcamp.bank2.mapper.LocalConfirmLogMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.dromara.hmily.annotation.Hmily;
import org.dromara.hmily.core.concurrent.threadlocal.HmilyTransactionContextLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@DubboService(version = "1.0.0")
@Slf4j
public class Bank2AccountInfoServiceImpl implements Bank2AccountInfoService {

    @Autowired
    LocalConfirmLogMapper localConfirmLogMapper;

    @Autowired
    AccountInfoMapper accountInfoMapper;

    @Override
    public String sayHello() {
        return "bank2:hello";
    }

    @Override
    @Hmily(confirmMethod = "confirmMethod", cancelMethod = "cancelMethod")
    public Boolean updateAccountBalance(String accountNo, Double amount) {
        // 获取全局事务id
        String transId = HmilyTransactionContextLocal.getInstance().get().getTransId();
        log.info("bank2 try again 开始执行...xid:{}", transId);
        return true;
    }

    /**
     * confirm方法
     * confirm幂等校验
     * 正式增加金额
     * @param accountNo
     * @param amount
     */
    @Transactional(rollbackFor = Exception.class)
    public void confirmMethod(String accountNo, Double amount) {
        // 获取全局事务id
        String transId = HmilyTransactionContextLocal.getInstance().get().getTransId();
        log.info("bank2 confirm begin 开始执行...xid:{}", transId);
        if (localConfirmLogMapper.isExistConfirm(transId) > 0) {
            log.info("bank2 confirm 已经执行，无需重复执行...xid:{}", transId);
            return;
        }
        // 增加金额
        accountInfoMapper.addAccountBalance(accountNo, amount);
        // 增加一条confirm日志，用于幂等
        LocalConfirmLog localConfirmLog = new LocalConfirmLog();
        localConfirmLog.setTxNo(transId);
        localConfirmLog.setCreateTime(new Date());
        localConfirmLogMapper.insert(localConfirmLog);
        log.info("bank2 confirm end 结束执行...xid:{}", transId);
    }

    @Transactional(rollbackFor = Exception.class)
    public void cancelMethod(String accountNo, Double amount) {
        // 获取全局事务id
        String transId = HmilyTransactionContextLocal.getInstance().get().getTransId();
        log.info("bank2 cancel begin 开始执行...xid:{}", transId);
    }
}
