package com.co.ecommerce.service;

import com.co.ecommerce.entity.Supplier;
import com.co.ecommerce.repository.SupplierRepository;
import com.co.ecommerce.web.dto.SupplierDTO;
import com.co.ecommerce.web.mapper.SupplierMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierService {
    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;

    // Create a new supplier
    @Transactional
    public void createSupplier(SupplierDTO supplierDTO) {
        // Validate the request
        if (supplierDTO.getSupplierName() == null || supplierDTO.getSupplierName().isEmpty()) {
            throw new IllegalArgumentException("Supplier name must not be empty");
        }
        // Map SupplierDTO to Supplier
        Supplier supplier = supplierMapper.mapSupplierDTOToSupplier(supplierDTO);
        // Save the supplier
        supplierRepository.save(supplier);
    }

    // Find all suppliers
    public List<SupplierDTO> getAllSuppliers() {
        List<Supplier> suppliers = supplierRepository.findAll();
        List<SupplierDTO> supplierDTOs = new ArrayList<>();

        for (Supplier supplier : suppliers) {
            supplierDTOs.add(supplierMapper.mapSupplierToSupplierDTO(supplier));
        }
        return supplierDTOs;
    }
}
