package com.co.ecommerce.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long productId;
    private String productName;
    private String unit;
    private Double price;
    private SupplierDTO supplier;
    private Long supplierId;
    private Long categoryId;
}
