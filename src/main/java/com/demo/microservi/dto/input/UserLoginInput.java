package com.demo.microservi.dto.input;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserLoginInput {
    private String username;
    private String password;
}
