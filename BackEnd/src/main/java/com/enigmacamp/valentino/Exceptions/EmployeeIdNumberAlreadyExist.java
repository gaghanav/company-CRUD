package com.enigmacamp.valentino.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class EmployeeIdNumberAlreadyExist extends HttpStatusCodeException {
    public EmployeeIdNumberAlreadyExist(Integer idNumber) {
        super(HttpStatus.BAD_REQUEST, String.format("There already another employee with id %d",idNumber));
    }
}
