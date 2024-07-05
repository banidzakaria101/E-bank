package com.example.service;

import com.example.model.Account;
import com.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountService {

    @Autowired
    private AccountRepository accountRepo;

    public Account addAccount(Account account){
        return accountRepo.save(account);
    }

}
