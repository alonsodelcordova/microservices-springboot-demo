package com.demo.microservi.controllers;

import com.demo.microservi.dto.input.UserLoginInput;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api( tags = {"Security"})
@RestController
@RequestMapping("/api/security")
public class SecurityController {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> login(@RequestBody UserLoginInput userInput){

        return new ResponseEntity<>(null);
    }
}
