package com.co.ecommerce.web.mapper;

import com.co.ecommerce.entity.Product;
import com.co.ecommerce.web.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "productId" ,source = "productId")
    @Mapping(target = "supplierId", source = "supplier.supplierId")
    @Mapping(target = "categoryId", source = "category.categoryId")
    ProductDTO mapProductToProductDTO(Product product);

    @Mapping(target = "productId" , ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "supplier", ignore = true)
    Product mapProductDTOToProduct(ProductDTO productDTO);
}
