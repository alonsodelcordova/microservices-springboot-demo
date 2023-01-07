package com.demo.microservi.services;

import com.demo.microservi.models.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<ProductEntity> getAll();
    Optional<ProductEntity> findById (String id);
    ProductEntity save(ProductEntity product);
    ProductEntity update(String Id, ProductEntity product);
    boolean deleteById(String id);
}
