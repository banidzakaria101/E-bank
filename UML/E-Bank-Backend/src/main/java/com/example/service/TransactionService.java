package com.example.service;

import com.example.model.Account;
import com.example.model.Transaction;
import com.example.repository.AccountRepository;
import com.example.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepo;

    @Autowired
    private AccountRepository accountRepo;


    public Transaction deposit(Long accountId, Double amount){

        Optional<Account> accountOp = accountRepo.findById(accountId);

        if(accountOp.isPresent()){
            Account account = accountOp.get();
            account.setBalance(account.getBalance() + amount);
            account.setBalance(amount);
            accountRepo.save(account);

            Transaction transaction = new Transaction();
            transaction.setToAccount(account);
            transaction.setAmount(amount);
            transaction.setTimestamp(LocalDateTime.now());

            return transactionRepo.save(transaction);
        } else {
            throw new RuntimeException("Account not found");
        }


//    public Transaction sendTransaction(Long fromAccountId, Long toAccountId, double amount){
//        Optional<Account> fromAccountOp = accountRepo.findById(fromAccountId);
//        Optional<Account> toAccountOp = accountRepo.findById(toAccountId);
//
//        Account fromAccount = fromAccountOp.get();
//        Account toAccount = toAccountOp.get();
//
//
//    }
    }

}
