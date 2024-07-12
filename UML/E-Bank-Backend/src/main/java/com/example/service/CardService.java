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


    public Card blockCard(Long cardId){
        Card card = cardRepo.findById(cardId).get();
        card.setStatus(CardStatus.blocked);
        return card;
    }

    public Card deactivateCard(Long cardId){
        Card card = cardRepo.findById(cardId).get();
        card.setStatus(CardStatus.inactive);
        return card;
    }

    public Card activateCard(Long cardId){
        Card card = cardRepo.findById(cardId).get();
        card.setStatus(CardStatus.active);
        return card;
    }
}
