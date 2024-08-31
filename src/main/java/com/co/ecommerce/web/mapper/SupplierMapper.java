package com.co.ecommerce.web.mapper;

import com.co.ecommerce.entity.Supplier;
import com.co.ecommerce.web.dto.SupplierDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

    @Mapping(target = "supplierId", source = "supplierId")
    SupplierDTO mapSupplierToSupplierDTO(Supplier supplier);

    @Mapping(target = "supplierId", ignore = true)
    Supplier mapSupplierDTOToSupplier(SupplierDTO supplierDTO);

}
