package com.co.ecommerce.web.mapper;

import com.co.ecommerce.entity.Order;
import com.co.ecommerce.entity.OrderDetail;
import com.co.ecommerce.web.dto.OrderDTO;
import com.co.ecommerce.web.dto.OrderDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "customerId", source = "customer.customerId")
    @Mapping(target = "employeeId", source = "employee.employeeId")
    @Mapping(target = "shipperId", source = "shipper.shipperId")
    @Mapping(target = "orderDetails", ignore = true)
    OrderDTO mapOrderToOrderDTO(Order order);

    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "employee", ignore = true)
    @Mapping(target = "shipper", ignore = true)
    @Mapping(target = "orderDetails", ignore = true)
    Order mapOrderDTOToOrder(OrderDTO orderDTO);

    @Mapping(target = "orderId", source = "order.orderId")
    @Mapping(target = "productId", source = "product.productId")
    OrderDetailDTO mapOrderDetailToOrderDetailDTO(OrderDetail orderDetail);

    List<OrderDetailDTO> mapOrderDetailsToOrderDetailDTO(List<OrderDetail> orderDetails);

}
