package com.demo.microservi.controllers;
import com.demo.microservi.models.UserEntity;
import com.demo.microservi.dto.input.UserInput;
import com.demo.microservi.services.IUserService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api( tags = {"Usuarios"})
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @Operation(summary = "Obtener Lista de Usuarios")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserEntity> getAllUsers(){
        return userService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserEntity createUser(@RequestBody UserInput input){
        UserEntity userEntity = new UserEntity(input);
        userEntity = userService.save(userEntity);
        return  userEntity;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserEntity> putUser(@PathVariable("id") String id, @RequestBody UserInput input){
        UserEntity userEntity = new UserEntity(input);
        UserEntity response = userService.update(id, userEntity);
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  ResponseEntity<?> deleteUser(@PathVariable("id") String userId){
        userService.deleteById(userId);
        return new ResponseEntity<>(Map.of("msg","Deleted!"),HttpStatus.OK);
    }

}
