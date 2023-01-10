package com.demo.microservi.services.impl;

import com.demo.microservi.dto.input.UserInput;
import com.demo.microservi.dto.input.UserLoginInput;
import com.demo.microservi.dto.output.UserLoginOutput;
import com.demo.microservi.exceptions.GeneralException;
import com.demo.microservi.models.TokenEntity;
import com.demo.microservi.models.UserEntity;
import com.demo.microservi.repository.TokenRepository;
import com.demo.microservi.services.ISecurityService;
import com.demo.microservi.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SecurityServiceImpl implements ISecurityService {
    @Autowired
    private IUserService userService;
    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public UserLoginOutput login(UserLoginInput input) {
        // usernamme => email
        UserEntity user = userService.getFindUserName(input.getUsername()).orElseThrow(
                ()-> new GeneralException(HttpStatus.NOT_FOUND, "Usuario no existe"));
        if(input.getPassword().equals(user.getPassword())){
            // generate token
            TokenEntity token;
            Optional<TokenEntity> tokenOptional = tokenRepository.findByUser(user.getId());
            if(tokenOptional.isEmpty()){
               token = tokenRepository.save(new TokenEntity(user.getId()));
            }else{
                token = tokenOptional.get();
            }
            return new UserLoginOutput(new UserInput(user), token);
        }
        throw new GeneralException(HttpStatus.BAD_REQUEST, "Contraseña Incorrecta!");
    }
}
