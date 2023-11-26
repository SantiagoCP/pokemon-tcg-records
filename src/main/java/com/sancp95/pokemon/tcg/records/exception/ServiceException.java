package com.sancp95.pokemon.tcg.records.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceException extends RuntimeException {

    private final String message;

    public ServiceException(String message) {
        super(message);
        this.message = message;
    }
}
