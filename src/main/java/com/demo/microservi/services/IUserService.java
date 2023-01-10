package com.demo.microservi.services;

import com.demo.microservi.models.ProductEntity;
import com.demo.microservi.models.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<UserEntity> getAll();
    Optional<UserEntity> getFindUserName(String email);
    UserEntity findById (String id);
    UserEntity save(UserEntity user);
    UserEntity update(String Id, UserEntity user);
    void deleteById(String id);
}
