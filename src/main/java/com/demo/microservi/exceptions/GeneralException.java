package com.demo.microservi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class GeneralException extends ResponseStatusException {

    public GeneralException(HttpStatus status, String msg){
        super(status,msg);
    }

}
