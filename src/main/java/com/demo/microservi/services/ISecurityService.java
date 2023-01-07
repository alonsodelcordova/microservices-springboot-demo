package com.demo.microservi.services;

import com.demo.microservi.models.UserEntity;
import com.demo.microservi.dto.input.UserLoginInput;

public interface ISecurityService {
    public UserEntity login(UserLoginInput input);
}
