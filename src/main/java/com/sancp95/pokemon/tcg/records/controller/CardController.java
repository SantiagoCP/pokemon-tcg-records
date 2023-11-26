package com.sancp95.pokemon.tcg.records.controller;

import com.sancp95.pokemon.tcg.records.dto.AddCardDto;
import com.sancp95.pokemon.tcg.records.model.CardEntity;
import com.sancp95.pokemon.tcg.records.service.CardService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/cards")
@RestController
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public List<CardEntity> getAllCards(
            @RequestParam(required = false) String pokemonName,
            @RequestParam(required = false) String additionalInfo,
            @RequestParam(required = false) String expansion) {

        return cardService.getAllCards(pokemonName, additionalInfo, expansion);
    }

    @PostMapping
    public void addCard(@RequestBody AddCardDto dto) {
        cardService.addCard(dto);
    }

    @DeleteMapping("/{cardId}")
    public void deleteCard(@PathVariable int cardId){
        cardService.deleteCard(cardId);
    }
}
