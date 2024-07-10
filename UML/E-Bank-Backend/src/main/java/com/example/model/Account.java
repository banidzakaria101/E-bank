package com.example.model;

import com.example.enums.AccountType;
import com.example.enums.BankName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String holderFirstName;
    private String holderLastName;
    private String holderPhoneNumber;
    private String accountNumber;
    private Double balance;
    private AccountType accountType;
    private BankName bankName;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    List<Transaction> transactions = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    List<Card> cards = new ArrayList<>();

}



