package com.demo.microservi.dto.input;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductInput {

    private String productName;
    private String productDescription;
    private double priceUnit;
}
