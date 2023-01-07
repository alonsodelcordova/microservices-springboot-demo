package com.demo.microservi.controllers;
import com.demo.microservi.models.ProductEntity;
import com.demo.microservi.dto.input.ProductInput;
import com.demo.microservi.services.IProductService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@Api( tags = {"Productos"})
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Operation(summary = "Obtener Lista de Productos")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductEntity> getAllProducts(){
        return productService.getAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductEntity createProduct(@RequestBody ProductInput input){
        ProductEntity productEntity = new ProductEntity(input);
        productEntity = productService.save(productEntity);
        return  productEntity;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductEntity> putProduct(@PathVariable("id") String id,@RequestBody ProductInput input){
        ProductEntity productEntity = new ProductEntity(input);
        ProductEntity response = productService.update(id, productEntity);
        if(response==null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  ResponseEntity<?> deleteProduct(@PathVariable("id") String productId){
        boolean resp = productService.deleteById(productId);
        if(!resp){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(Map.of("msg","Deleted!"),HttpStatus.OK);
    }

}
