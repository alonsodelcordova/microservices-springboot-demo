package com.demo.microservi.dto.output;

import com.demo.microservi.dto.input.UserInput;
import com.demo.microservi.models.TokenEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserLoginOutput {
    private UserInput user;
    private String token;

    public UserLoginOutput(UserInput user, TokenEntity token){
        this.user = user;
        this.token = token.getToken();
    }
}
