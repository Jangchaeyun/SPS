package com.cherry.service.Impl;

import com.cherry.exceptions.UserException;
import com.cherry.mapper.CategoryMapper;
import com.cherry.modal.Category;
import com.cherry.modal.Store;
import com.cherry.modal.User;
import com.cherry.payload.dto.CategoryDTO;
import com.cherry.repository.CategoryRepository;
import com.cherry.repository.UserRepository;
import com.cherry.service.CategoryService;
import com.cherry.service.UserService;
import com.cherry.service.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    private final StoreRepository storeRepository;

    @Override
    public CategoryDTO createCategory(CategoryDTO dto) throws UserException, Exception {
        User user = userService.getCurrentUser();

        Store store = storeRepository.findById(dto.getStoreId()).orElseThrow(
                () -> new Exception("Store not found")
        );

        Category category = Category.builder()
                .store(store)
                .name(dto.getName())
                .build();

        return CategoryMapper.toDTO(category);
    }

    @Override
    public List<CategoryDTO> getCategoriesByStore(Long storeId) {
        List<Category> categories = categoryRepository.findByStoreId(storeId);
        return categories.stream()
                .map(
                        CategoryMapper::toDTO
                ).collect(Collectors.toList());
    }

    @Override
    public CategoryDTO updateCategory(Long id, CategoryDTO dto) throws Exception, UserException {
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new Exception("category not exist")
        );

        User user = userService.getCurrentUser();

        category.setName(dto.getName());
        return CategoryMapper.toDTO(categoryRepository.save(category));
    }

    @Override
    public void deleteCategory(Long id) throws Exception, UserException {
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new Exception("category not exist")
        );

        User user = userService.getCurrentUser();

        categoryRepository.delete(category);
    }
}
