package com.example.controller;


import com.example.model.Transaction;
import com.example.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/deposit/{accountId}")
    public Transaction deposit(@PathVariable Long accountId, @RequestParam Double amount){
        return  transactionService.deposit(accountId, amount);
    }

    @PostMapping("withdraw/{accountId}")
    public Transaction withdraw(@PathVariable Long accountId,@RequestParam Double amount){
        return transactionService.withdraw(accountId, amount);
    }
}
