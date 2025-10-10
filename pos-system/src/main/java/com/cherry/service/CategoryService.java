package com.cherry.service;

import com.cherry.exceptions.UserException;
import com.cherry.modal.Category;
import com.cherry.payload.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO createCategory(CategoryDTO dto) throws UserException, Exception;
    List<CategoryDTO> getCategoriesByStore(Long storeId);
    CategoryDTO updateCategory(Long id, CategoryDTO dto) throws Exception, UserException;
    void deleteCategory(Long id) throws Exception, UserException;
}
