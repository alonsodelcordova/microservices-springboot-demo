package com.demo.microservi.dto.input;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
public class UserInput {
    @Indexed(unique = true)
    private String email;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String password;
    private String fechaNacimiento;
}
