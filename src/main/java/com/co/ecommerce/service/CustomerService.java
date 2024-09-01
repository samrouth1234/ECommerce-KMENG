package com.co.ecommerce.service;

import com.co.ecommerce.entity.Customer;
import com.co.ecommerce.repository.CustomerRepository;
import com.co.ecommerce.web.dto.CustomerDTO;
import com.co.ecommerce.web.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    // Create customer
    public void createCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.mapCustomerDTOToCustomer(customerDTO);
        customerRepository.save(customer);
    }

    // Find all customer
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(customerMapper::mapCustomerToCustomerDTO)
                .collect(Collectors.toList());
    }

    // Find Customer By ID
    public CustomerDTO getCustomerById(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new RuntimeException("Customer not found")
        );
        return customerMapper.mapCustomerToCustomerDTO(customer);
    }

    // Deleted Customer By ID
    public void deleteCustomerById(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    // Update Customer By ID
    public void updateCustomerById(Long customerId, CustomerDTO customerDTO) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new RuntimeException("Customer not found")
        );
        customer.setCustomerName(customerDTO.getCustomerName());
        customer.setContactName(customerDTO.getContactName());
        customer.setAddress(customerDTO.getAddress());
        customer.setCity(customerDTO.getCity());
        customer.setCountry(customerDTO.getCountry());
        customer.setPostalCode(customerDTO.getPostalCode());
        customerRepository.save(customer);
    }
}
