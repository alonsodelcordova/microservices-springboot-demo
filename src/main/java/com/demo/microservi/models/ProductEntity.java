package com.demo.microservi.models;

import com.demo.microservi.dto.input.ProductInput;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// referencia a tabla de mongo db -> a traves de Libreria Mongo Web de springBoot
@Document(value = "product")
@Data
@NoArgsConstructor
public class ProductEntity{
    @Id
    private String id;
    private String productName;
    private String productDescription;
    private double priceUnit;
    public ProductEntity(ProductInput input){
        this.setProductName( input.getProductName());
        this.setProductDescription(input.getProductDescription());
        this.setPriceUnit( input.getPriceUnit());
    }
}
