package com.bootcamp.bank.service;


import org.dromara.hmily.annotation.Hmily;

public interface Bank2BalanceService {

    // 账户扣款
    @Hmily
    public Boolean dollarExchangeRmb(String accountNo, Double dollar, Double rmb);
}
