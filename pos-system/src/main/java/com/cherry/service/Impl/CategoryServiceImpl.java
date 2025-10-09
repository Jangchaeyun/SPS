package com.cherry.service.Impl;

import com.cherry.exceptions.UserException;
import com.cherry.mapper.CateoryMapper;
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

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    private final StoreRepository storeRepository;

    @Override
    public CategoryDTO createCategory(CategoryDTO dto) throws UserException {
        User user = userService.getCurrentUser();

        Store store = storeRepository.findById(dto.getStoreId()).orElseThrow(
                () -> new Exception("Store not found")
        );

        Category category = Category.builder()
                .store(store)
                .name(dto.getName())
                .build();

        return CateoryMapper.toDTO(category);
    }

    @Override
    public List<CategoryDTO> getCategoriesByStore(Long storeId) {
        return List.of();
    }

    @Override
    public CategoryDTO updateCategory(Long id, CategoryDTO dto) {
        return null;
    }

    @Override
    public void deleteCategory(Long id) {

    }
}
