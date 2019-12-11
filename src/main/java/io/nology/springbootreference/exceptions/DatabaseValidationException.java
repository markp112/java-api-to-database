package io.nology.springbootreference.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class DatabaseValidationException extends RuntimeException{
    public DatabaseValidationException(String message) {
        super(message);
    }
}
