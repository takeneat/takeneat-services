package com.takeneat.services.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Represents a HTTP 404 Not Found error code.
 *
 * @author paoesco
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception {

    public NotFoundException(Long id) {
        super("Entity with id " + id + " does not exists");
    }

}
