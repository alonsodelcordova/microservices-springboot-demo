package com.demo.microservi.services.impl;

import com.demo.microservi.exceptions.GeneralException;
import com.demo.microservi.models.UserEntity;
import com.demo.microservi.repository.UserRepository;
import com.demo.microservi.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity findById(String id) {
        return userRepository.findById(id).orElseThrow(
                ()-> new GeneralException(HttpStatus.NOT_FOUND, "Usuario no encontrado")
        );
    }

    @Override
    public UserEntity save(UserEntity user) {
        try{
            return userRepository.save(user);
        }catch (DuplicateKeyException e){
            throw  new GeneralException(HttpStatus.BAD_REQUEST,e.getCause().toString());
        }
    }

    @Override
    public UserEntity update(String Id, UserEntity product) {
        UserEntity userUpd = this.findById(Id);
        userUpd.setNombres(product.getNombres());
        userUpd.setFechaNacimiento(product.getFechaNacimiento());
        userUpd.setEmail(product.getEmail());
        userUpd.setApellidoPaterno(product.getApellidoPaterno());
        userUpd.setApellidoMaterno(product.getApellidoMaterno());
        userUpd.setPassword(product.getPassword());
        UserEntity response = userRepository.save(userUpd);
        return response;
    }

    @Override
    public void deleteById(String id) {
        UserEntity user = this.findById(id);
        userRepository.delete(user);
    }
}
