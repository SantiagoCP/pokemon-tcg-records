package com.sancp95.pokemon.tcg.records.service;

import com.sancp95.pokemon.tcg.records.dto.AddCardDto;
import com.sancp95.pokemon.tcg.records.exception.ServiceException;
import com.sancp95.pokemon.tcg.records.model.CardEntity;
import com.sancp95.pokemon.tcg.records.model.mapper.CardEntityMapper;
import com.sancp95.pokemon.tcg.records.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<CardEntity> getAllCards(String pokemonName, String additionalInfo, String expansion) {
        if(Objects.nonNull(pokemonName)){
            pokemonName = pokemonName.trim().toUpperCase();
        }
        if(Objects.nonNull(additionalInfo)){
            additionalInfo = additionalInfo.trim().toUpperCase();
        }
        if(Objects.nonNull(expansion)){
            expansion = expansion.trim().toUpperCase();
        }
        return cardRepository.findByPokemonNameContainingOrAdditionalInfoContainingOrExpansionContaining(pokemonName, additionalInfo, expansion);
    }

    public void addCard(AddCardDto dto) {
        CardEntity cardEntity = CardEntityMapper.mapToCardEntity(dto);
        Optional<CardEntity> currentCard =
                cardRepository.findByPokemonNameAndAdditionalInfoAndIndex(cardEntity.getPokemonName(), cardEntity.getAdditionalInfo(), cardEntity.getIndex());
        if (currentCard.isPresent()) {
            throw new ServiceException(String.format("Card %s %s already registered", cardEntity.getPokemonName(), cardEntity.getAdditionalInfo()));
        }
        cardRepository.save(cardEntity);
    }

    public void deleteCard(int cardId) {
        cardRepository.deleteById(cardId);
    }
}
