package com.example.repository;

import com.example.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query(value = "select * from  transaction where from_acc_id = ?", nativeQuery = true)
    List<Transaction> findAllByAccountId(Long accountId);
}
