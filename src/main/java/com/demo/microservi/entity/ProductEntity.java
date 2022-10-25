package com.demo.microservi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// referencia a tabla de mongo db -> a traves de Libreria Mongo Web de springBoot
@Document(value = "product")
@Getter
@Setter
@NoArgsConstructor
public class ProductEntity {
    @Id
    private String id;
    private String productName;
    private String productDescription;
    private double priceUnit;

}
