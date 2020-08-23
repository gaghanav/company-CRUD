package com.enigmacamp.valentino.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class EmployeeNotFoundException extends HttpStatusCodeException {
    public EmployeeNotFoundException() {
        super(HttpStatus.BAD_REQUEST, "Employee Not Found");
    }
}
