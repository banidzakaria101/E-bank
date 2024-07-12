package com.example.controller;

import com.example.model.Card;
import com.example.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/card")
public class CardController {

    @Autowired
    CardService cardService;

    @PostMapping("/deactivate/{cardId}")
    public Card deactivate(@PathVariable Long cardId){
        return cardService.activateCard(cardId);
    }

    @PostMapping("/activate/{cardId}")
    public Card activate(@PathVariable Long cardId){
        return cardService.deactivateCard(cardId);
    }

    @PostMapping("/block/{cardId}")
    public Card blockCard(@PathVariable Long cardId){
        return cardService.blockCard(cardId);
    }
}
