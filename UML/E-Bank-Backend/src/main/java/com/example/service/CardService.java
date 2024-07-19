package com.example.service;

import com.example.enums.CardStatus;
import com.example.model.Card;
import com.example.repository.CardRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepo;


    public Card blockCard(Long accountId){
        Card card = cardRepo.findByAccountId(accountId).orElseThrow(() -> new RuntimeException("Card not found"));
        card.setStatus(CardStatus.blocked);
        return card;
    }

    public Card deactivateCard(Long accountId){
        Card card = cardRepo.findByAccountId(accountId).orElseThrow(() -> new RuntimeException("Card not found"));
        card.setStatus(CardStatus.inactive);
        return card;
    }

    public Card activateCard(Long accountId){
        Card card = cardRepo.findByAccountId(accountId).orElseThrow(() -> new RuntimeException("Card not found"));
        card.setStatus(CardStatus.active);
        return card;
    }
}
