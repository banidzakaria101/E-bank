package com.example.service;

import com.example.enums.TransactionType;
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
            transaction.setTransactionType(TransactionType.DEPOSIT);

            return transactionRepo.save(transaction);
        } else {
            throw new RuntimeException("Account not found");
        }
    }

    public Transaction sendTransaction(Long fromAccountId, Long toAccountId, Double amount) {
        Optional<Account> fromAccountOptional = accountRepo.findById(fromAccountId);
        Optional<Account> toAccountOptional = accountRepo.findById(toAccountId);

        if (fromAccountOptional.isPresent() && toAccountOptional.isPresent()) {
            Account fromAccount = fromAccountOptional.get();
            Account toAccount = toAccountOptional.get();

            if (fromAccount.getBalance() >= amount) {
                fromAccount.setBalance(fromAccount.getBalance() - amount);
                toAccount.setBalance(toAccount.getBalance() + amount);

                accountRepo.save(fromAccount);
                accountRepo.save(toAccount);

                Transaction transaction = new Transaction();
                transaction.setFromAccount(fromAccount);
                transaction.setToAccount(toAccount);
                transaction.setAmount(amount);
                transaction.setTimestamp(LocalDateTime.now());
                transaction.setTransactionType(TransactionType.TRANSFER);

                return transactionRepo.save(transaction);
            } else {
                throw new RuntimeException("Insufficient funds");
            }
        } else {
            throw new RuntimeException("Account not found");
        }
    }


    public Transaction withdraw(Long accountId, Double amount){
        Optional<Account> accountOp = accountRepo.findById(accountId);

        if(accountOp.isPresent()){
            Account account = accountOp.get();

            if (account.getBalance() >= amount){
                account.setBalance(account.getBalance() - amount);
                accountRepo.save(account);

                Transaction transaction = new Transaction();
                transaction.setFromAccount(account);
                transaction.setAmount(amount);
                transaction.setTimestamp(LocalDateTime.now());
                transaction.setTransactionType(TransactionType.WITHDRAW);

                return  transactionRepo.save(transaction);

            }else{
                throw new RuntimeException("Insufficient!");
            }


        }else {
            throw new RuntimeException("Account dose not exist");
        }
    }


}
