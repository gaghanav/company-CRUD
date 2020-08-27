package com.enigmacamp.valentino.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

public class EmployeeNotFoundException extends ResponseStatusException {
    public EmployeeNotFoundException() {
        super(HttpStatus.NOT_FOUND);
    }
}
