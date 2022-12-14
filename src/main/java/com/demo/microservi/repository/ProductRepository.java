package com.demo.microservi.repository;

import com.demo.microservi.models.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<ProductEntity, String>
{
    @Query("{'productName' : ?0}")
    List<ProductEntity> findByName(String productName);

}
