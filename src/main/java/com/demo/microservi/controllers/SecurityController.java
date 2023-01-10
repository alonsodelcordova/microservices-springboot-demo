package com.demo.microservi.controllers;

import com.demo.microservi.dto.input.UserLoginInput;
import com.demo.microservi.dto.output.UserLoginOutput;
import com.demo.microservi.services.ISecurityService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api( tags = {"Security"})
@RestController
@RequestMapping("/api/security")
public class SecurityController {

    @Autowired
    private ISecurityService securityService;
    @PostMapping
    public ResponseEntity<?> login(@RequestBody UserLoginInput userInput){
        UserLoginOutput userLogout = securityService.login(userInput);
        return new ResponseEntity<>(userLogout, HttpStatus.OK);
    }
}
