package com.bootcamp.bank1.controller;

import com.bootcamp.bank1.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Bank1Controller {

    @Autowired
    BalanceService accountInfoService;

    @RequestMapping("/transfer")
    public Boolean transfer(@RequestParam("amount") Double amount) {
        accountInfoService.updateAccountBalance("1", amount);
        return true;
    }

    @RequestMapping("/hello")
    public String hello() {
        return accountInfoService.hello();
    }
}
