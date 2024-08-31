package com.co.ecommerce.web.mapper;

import com.co.ecommerce.entity.Shipper;
import com.co.ecommerce.web.dto.ShipperDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ShipperMapper {

    @Mapping(target = "shipperId" ,source = "shipper.shipperId")
    ShipperDTO mapShipperToShipperDTO(Shipper shipper);

    Shipper mapShipperDTOToShipper(ShipperDTO shipperDTO);
}
