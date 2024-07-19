package com.example.controller;

import com.example.model.Card;
import com.example.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/card")
public class CardController {

    @Autowired
    CardService cardService;

    @PostMapping("/deactivate/{accountId}")
    public Card deactivate(@PathVariable Long accountId){
        return cardService.deactivateCard(accountId);
    }

    @PostMapping("/activate/{accountId}")
    public Card activate(@PathVariable Long accountId){
        return cardService.activateCard(accountId);
    }

    @PostMapping("/block/{cardId}")
    public Card blockCard(@PathVariable Long accountId){
        return cardService.blockCard(accountId);
    }
}
