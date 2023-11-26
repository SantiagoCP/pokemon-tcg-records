package com.sancp95.pokemon.tcg.records.model.mapper;

import com.sancp95.pokemon.tcg.records.dto.AddCardDto;
import com.sancp95.pokemon.tcg.records.model.CardEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CardEntityMapper {

    public static CardEntity mapToCardEntity(AddCardDto dto) {
        CardEntity cardEntity = new CardEntity();
        cardEntity.setPokemonName(dto.getPokemonName().trim().toUpperCase());
        cardEntity.setIndex(dto.getIndex().trim().toUpperCase());
        cardEntity.setAdditionalInfo(dto.getAdditionalInfo().trim().toUpperCase());
        cardEntity.setExpansion(dto.getExpansion().trim().toUpperCase());
        return cardEntity;
    }
}
