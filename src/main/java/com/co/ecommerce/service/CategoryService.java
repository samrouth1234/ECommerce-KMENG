package com.co.ecommerce.service;

import com.co.ecommerce.entity.Category;
import com.co.ecommerce.repository.CategoryRepository;
import com.co.ecommerce.web.dto.CategoryDTO;
import com.co.ecommerce.web.mapper.CategoryMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    // Create a new category
    @Transactional
    public void createCategory(CategoryDTO categoryDTO) {
        // Validate the request
        if (categoryDTO.getCategoryName() == null || categoryDTO.getCategoryName().isEmpty()) {
            throw new IllegalArgumentException("Category name must not be empty");
        }

        // Create and save the category
        Category category = categoryMapper.mapCategoryDTOToCategory(categoryDTO);
        categoryRepository.save(category);
    }

    // Find all categories
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(categoryMapper::mapCategoryToCategoryDTO)
                .collect(Collectors.toList());
    }
}
