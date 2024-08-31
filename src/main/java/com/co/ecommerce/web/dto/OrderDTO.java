package com.co.ecommerce.web.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO{
    private Long orderId;
    private Long customerId;
    private Long employeeId;
    private LocalDate orderDate;
    private Long shipperId;
    private List<OrderDetailDTO> orderDetails;

}
