package com.github.damianw345.shopdemo.controller;

import com.github.damianw345.shopdemo.dao.AccountDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController("/")
public class Dummy {

    private final AccountDao accountDao;

    @Inject
    public Dummy(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @GetMapping("dummyMethod")
    public void dummyMethod(){

        accountDao.addAccount();
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }
}
