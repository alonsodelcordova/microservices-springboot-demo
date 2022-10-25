package com.demo.microservi.repository;

import com.demo.microservi.entity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductRepository extends MongoRepository<ProductEntity, String>
{

}
