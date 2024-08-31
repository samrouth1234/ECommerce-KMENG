package com.co.ecommerce.client.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private String productName;
    private String unit;
    private Double price;
    private Long supplierId;
    private Long categoryId;
}
