package com.example.controller;

import com.example.model.Account;
import com.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/account/{userId}")
    public Account addAccount(@PathVariable Long userId, @RequestBody Account account) {
        return accountService.addAccount(userId, account);
    }
}
