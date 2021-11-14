package com.bootcamp.bank2.service;

public interface Bank2AccountInfoService {

    // 账户扣款
    public void updateAccountBalance(String accountNo, Double amount);
}
