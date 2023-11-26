package com.sancp95.pokemon.tcg.records.repository;

import com.sancp95.pokemon.tcg.records.model.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, Integer> {

    List<CardEntity> findByPokemonNameContainingOrAdditionalInfoContainingOrExpansionContaining(String pokemonName, String additionalInfo, String expansion);

    Optional<CardEntity> findByPokemonNameAndAdditionalInfoAndIndex(String pokemonName, String additionalInfo, String index);
}
