package com.demo.microservi.dto.input;

import com.demo.microservi.models.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserInput {
    private String email;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String password;
    private String fechaNacimiento;

    public  UserInput(UserEntity input){
        this.email = input.getEmail();
        this.nombres = input.getNombres();
        this.apellidoPaterno = input.getApellidoPaterno();
        this.apellidoMaterno = input.getApellidoMaterno();
        this.password = input.getPassword();
        this.fechaNacimiento = input.getFechaNacimiento();
    }
}
