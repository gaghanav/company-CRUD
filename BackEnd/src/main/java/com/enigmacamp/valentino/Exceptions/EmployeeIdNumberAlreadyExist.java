package com.enigmacamp.valentino.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

public class EmployeeIdNumberAlreadyExist extends ResponseStatusException {
    public EmployeeIdNumberAlreadyExist() {
        super(HttpStatus.NOT_ACCEPTABLE);
    }
}
