package com.co.ecommerce.web;

import com.co.ecommerce.client.request.CategoryRequest;
import com.co.ecommerce.entity.Category;
import com.co.ecommerce.service.CategoryService;
import com.co.ecommerce.web.dto.CategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categorys")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Category> createCategory(@RequestBody CategoryDTO CategoryDTO) {
        categoryService.createCategory(CategoryDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }

}
