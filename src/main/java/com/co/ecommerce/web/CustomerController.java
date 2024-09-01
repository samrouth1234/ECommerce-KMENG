package com.co.ecommerce.web;

import com.co.ecommerce.entity.Customer;
import com.co.ecommerce.service.CustomerService;
import com.co.ecommerce.web.dto.CustomerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.createCustomer(customerDTO);
        return new ResponseEntity<>(customerDTO, HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDTO> getCustomers() {
        return  customerService.getAllCustomers();
    }

    @GetMapping("/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Long customerId) {
        customerService.getCustomerById(customerId);
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable Long customerId) {
        customerService.deleteCustomerById(customerId);
    }

    @PutMapping("/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCustomerById(@PathVariable Long customerId, @RequestBody CustomerDTO customerDTO) {
        customerService.updateCustomerById(customerId, customerDTO);
    }
}
