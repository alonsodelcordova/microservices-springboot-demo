package com.demo.microservi.repository;
import com.demo.microservi.models.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String>
{
    @Query("{'email' : ?0}")
    Optional<UserEntity> findByEmail(String email);
}
