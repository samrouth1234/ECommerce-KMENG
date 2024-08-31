package com.co.ecommerce.web;

import com.co.ecommerce.entity.Supplier;
import com.co.ecommerce.service.SupplierService;
import com.co.ecommerce.web.dto.SupplierDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/suppliers")
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;

    @PostMapping
    public ResponseEntity<Supplier> save(@RequestBody SupplierDTO supplierDTO) {
        supplierService.createSupplier(supplierDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public List<SupplierDTO> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }
}
