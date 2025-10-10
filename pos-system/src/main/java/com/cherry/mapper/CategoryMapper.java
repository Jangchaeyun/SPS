package com.cherry.mapper;

import com.cherry.modal.Category;
import com.cherry.payload.dto.CategoryDTO;

public class CategoryMapper {
    public static CategoryDTO toDTO(Category category){
        return CategoryDTO.builder()
                .name(category.getName())
                .storeId(category.getStore() != null ? category.getStore().getId() : null)
                .build();
    }
}
