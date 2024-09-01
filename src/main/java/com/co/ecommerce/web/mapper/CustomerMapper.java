package com.co.ecommerce.web.mapper;

import com.co.ecommerce.entity.Customer;
import com.co.ecommerce.web.dto.CustomerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "customerId" , source = "customer.customerId")
    CustomerDTO mapCustomerToCustomerDTO(Customer customer);

    Customer mapCustomerDTOToCustomer(CustomerDTO customerDTO);
}
