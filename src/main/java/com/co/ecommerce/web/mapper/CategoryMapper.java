package com.co.ecommerce.web.mapper;

import com.co.ecommerce.entity.Category;
import com.co.ecommerce.web.dto.CategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "categoryId" , source = "category.categoryId")
    CategoryDTO mapCategoryToCategoryDTO(Category category);

    Category mapCategoryDTOToCategory(CategoryDTO categoryDTO);
}
