package com.demo.microservi.models;

import com.demo.microservi.dto.input.UserInput;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "user")
@Data
@NoArgsConstructor
public class UserEntity{
    @Id
    private String id;
    @Indexed(unique = true)
    private String email;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String password;
    private String fechaNacimiento;

    public UserEntity(UserInput input){
        this.setEmail(input.getEmail());
        this.setNombres(input.getNombres());
        this.setApellidoPaterno(input.getApellidoPaterno());
        this.setApellidoMaterno(input.getApellidoMaterno());
        this.setPassword(input.getPassword());
        this.setFechaNacimiento(input.getFechaNacimiento());
    }
}
