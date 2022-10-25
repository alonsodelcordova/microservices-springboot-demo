package com.demo.microservi.controllers;
import com.demo.microservi.entity.ProductEntity;
import com.demo.microservi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductEntity> getAllProducts(){
        return productRepository.findAll();
    }

    /*@GetMapping("/all")
    public ResponseEntity<List<ProductEntity>> getAllProductAll(){
        List<ProductEntity> listProduct = productRepository.findAll();
        ResponseEntity<List<ProductEntity>> resList = new ResponseEntity<>(
                listProduct, HttpStatus.OK
        );
        return resList;
    }*/

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductEntity createProduct(@RequestBody ProductEntity productEntity){
        productEntity = productRepository.save(productEntity);
        return  productEntity;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductEntity> putProduct(@PathVariable("id") String id,@RequestBody ProductEntity productEntity){
        Optional<ProductEntity> product = productRepository.findById(id);
        if(product.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        product.ifPresent(s->{
            s.setProductName(productEntity.getProductName());
            s.setProductDescription(productEntity.getProductDescription());
            s.setPriceUnit(productEntity.getPriceUnit());
        });
        productRepository.save(product.get());
        return  new ResponseEntity<>(product.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  ResponseEntity<?> deleteProduct(@PathVariable("id") String productId){
        Optional<ProductEntity> product = productRepository.findById(productId);
        if(product.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        productRepository.delete(product.get());
        return new ResponseEntity<>(Map.of("msg","Deleted!"),HttpStatus.OK);
    }

}
