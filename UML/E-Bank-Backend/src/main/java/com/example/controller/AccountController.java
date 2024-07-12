package com.example.controller;

import com.example.model.Account;
import com.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/account/{userId}")
    public Account addAccount(@PathVariable Long userId, @RequestBody Account account) {
        return accountService.addAccount(userId, account);
    }

    @DeleteMapping("/delete/{accountId}")
    public void deleteAccount(@PathVariable Long accountId) {
        accountService.deleteAccount(accountId);
    }

    @GetMapping("/all-accounts/{userId}")
    public List<Account> getAllAccounts(@PathVariable Long userId){
        return  accountService.getAccountsByUserId(userId);
    }
}
