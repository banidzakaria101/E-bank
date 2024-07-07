package com.example.model;

import com.example.enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    private String beneficiary;
    private LocalDateTime timestamp;
    private TransactionType transactionType;

    @ManyToOne
    @JoinColumn(name = "from_acc_id")
    private Account fromAccount;

    @ManyToOne
    @JoinColumn(name = "to_acc_id")
    private Account toAccount;



}

