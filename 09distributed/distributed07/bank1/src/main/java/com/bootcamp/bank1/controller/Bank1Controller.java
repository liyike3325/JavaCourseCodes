package com.bootcamp.bank1.controller;

import com.bootcamp.bank.service.Bank2BalanceService;
import com.bootcamp.bank1.service.BalanceService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Bank1Controller {

    @Autowired
    BalanceService balanceService;

    @DubboReference(version = "1.0.0", url = "dubbo://127.0.0.1:12345")
    Bank2BalanceService bank2BalanceService;

    @RequestMapping("/dollarExchangeRmb")
    public Boolean transfer(@RequestParam("rmb") Double rmb) {
        balanceService.dollarExchangeRmb("1", rmb);
        return true;
    }

    @RequestMapping("/hello")
    public String hello() {
        return bank2BalanceService.hello();
    }
}
