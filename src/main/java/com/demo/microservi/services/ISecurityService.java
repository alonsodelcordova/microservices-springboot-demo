package com.demo.microservi.services;

import com.demo.microservi.dto.output.UserLoginOutput;
import com.demo.microservi.models.UserEntity;
import com.demo.microservi.dto.input.UserLoginInput;

public interface ISecurityService {
    public UserLoginOutput login(UserLoginInput input);
}
