package com.example.model;

import com.example.enums.CardType;
import com.example.enums.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cardNumber;
    private String cardHolderName;
    private CardType cardType;
    private LocalDate expiryDate;
    private CardStatus status;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
