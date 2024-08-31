package com.co.ecommerce.web.mapper;

import com.co.ecommerce.entity.OrderDetail;
import com.co.ecommerce.web.dto.OrderDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderDetailMapper {
    @Mapping(target = "orderId", source = "order.orderId")
    @Mapping(target = "productId", source = "product.productId")
    OrderDetailDTO mapOrderDetailToOrderDetailDTO(OrderDetail orderDetail);

    @Mapping(target = "order", ignore = true)
    @Mapping(target = "product", ignore = true)
    OrderDetail mapOrderDetailDTOToOrderDetail(OrderDetailDTO orderDetailDTO);
}