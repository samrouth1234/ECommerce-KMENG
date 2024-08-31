package com.co.ecommerce.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipperDTO {
    private Long shipperId;
    private String shipperName;
    private String phone;
}
