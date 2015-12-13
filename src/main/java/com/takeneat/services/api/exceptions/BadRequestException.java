package com.takeneat.services.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Represents a HTTP 400 Not Found error code.
 *
 * @author paoesco
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends Exception {

    public BadRequestException(String message) {
        super(message);
    }

}
