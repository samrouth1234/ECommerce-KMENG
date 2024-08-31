package com.co.ecommerce.service;

import com.co.ecommerce.entity.Category;
import com.co.ecommerce.entity.Product;
import com.co.ecommerce.entity.Supplier;
import com.co.ecommerce.repository.CategoryRepository;
import com.co.ecommerce.repository.ProductRepository;
import com.co.ecommerce.repository.SupplierRepository;
import com.co.ecommerce.web.dto.ProductDTO;
import com.co.ecommerce.web.mapper.ProductMapper;
import com.co.ecommerce.web.mapper.SupplierMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    // Create Product
    public void createProduct(ProductDTO productDTO) {
        // Validate the request
        if (productDTO.getProductName() == null || productDTO.getProductName().isEmpty()) {
            throw new IllegalArgumentException("Product name must not be empty");
        }
        if (productDTO.getPrice() == null || productDTO.getPrice() < 0) {
            throw new IllegalArgumentException("Product price must be a positive number");
        }

        Supplier supplier = supplierRepository.findById(productDTO.getSupplierId())
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Product product = productMapper.mapProductDTOToProduct(productDTO);
        product.setSupplier(supplier);
        product.setCategory(category);
        productRepository.save(product);
    }

    // Find All Products
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productMapper::mapProductToProductDTO)
                .collect(Collectors.toList());
    }

    // Find product by id
    public ProductDTO getProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        // Convert Product to ProductDTO
        return productMapper.mapProductToProductDTO(product);
    }
}
