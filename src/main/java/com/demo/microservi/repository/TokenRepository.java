package com.demo.microservi.repository;
import com.demo.microservi.models.TokenEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository extends MongoRepository<TokenEntity, String> {
    @Query("{'idUser' : ?0}")
    Optional<TokenEntity> findByUser(String idUser);
}
