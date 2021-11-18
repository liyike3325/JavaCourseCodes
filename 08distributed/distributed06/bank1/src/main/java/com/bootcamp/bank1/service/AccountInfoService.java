package com.bootcamp.bank1.service;

public interface AccountInfoService {

    // 账户扣款
    public void updateAccountBalance(String accountNo, Double amount);

    public String hello();
}
