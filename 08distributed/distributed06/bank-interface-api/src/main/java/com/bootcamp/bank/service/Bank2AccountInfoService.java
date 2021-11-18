package com.bootcamp.bank.service;


import org.dromara.hmily.annotation.Hmily;

public interface Bank2AccountInfoService {

    // 账户扣款
    @Hmily
    public Boolean updateAccountBalance(String accountNo, Double amount);

    public String sayHello();
}
