package com.sancp95.pokemon.tcg.records.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "CARDS")
@Entity(name = "CARD")
@Getter
@Setter
public class CardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "POKEMON_NAME")
    private String pokemonName;

    @Column(name = "ADDITIONAL_INFO")
    private String additionalInfo;

    private String index;

    private String expansion;
}
