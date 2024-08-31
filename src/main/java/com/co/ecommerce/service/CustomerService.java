package com.co.ecommerce.service;

import com.co.ecommerce.entity.Customer;
import com.co.ecommerce.repository.CustomerRepository;
import com.co.ecommerce.web.dto.CustomerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    // create customer
    public void createCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setCustomerName(customerDTO.getCustomerName());
        customer.setContactName(customerDTO.getContactName());
        customer.setCountry(customerDTO.getCountry());
        customer.setCity(customerDTO.getCity());
        customer.setAddress(customerDTO.getAddress());
        customer.setPostalCode(customerDTO.getPostalCode());
        customer.setCountry(customerDTO.getCountry());
        customerRepository.save(customer);
    }

    // find all customer
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
