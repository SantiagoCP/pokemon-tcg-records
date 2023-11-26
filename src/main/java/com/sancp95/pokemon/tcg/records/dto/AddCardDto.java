package com.sancp95.pokemon.tcg.records.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddCardDto {

    @NotEmpty
    private String pokemonName;

    @NotEmpty
    private String additionalInfo;

    @NotEmpty
    private String index;

    @NotEmpty
    private String expansion;
}
