package com.cherry.controller;

import com.cherry.exceptions.UserException;
import com.cherry.payload.dto.CategoryDTO;
import com.cherry.payload.response.ApiResponse;
import com.cherry.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(
            @RequestBody CategoryDTO categoryDTO
    ) throws UserException, Exception {
        return ResponseEntity.ok(categoryService.createCategory(categoryDTO));
    }

    @GetMapping("/store/{storeId}")
    public ResponseEntity<List<CategoryDTO>> getCategoriesStoreId(
            @PathVariable Long storeId
    ) throws Exception {
        return ResponseEntity.ok(
                categoryService.getCategoriesByStore(storeId)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(
            @RequestBody CategoryDTO categoryDTO,
            @PathVariable Long id
    ) throws Exception, UserException {
        return ResponseEntity.ok(
                categoryService.updateCategory(id, categoryDTO)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteCategory(
            @RequestBody CategoryDTO categoryDTO,
            @PathVariable Long id
    ) throws Exception, UserException {

        categoryService.updateCategory(id, categoryDTO);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("category deleted successfully");

        return ResponseEntity.ok(
                apiResponse
        );
    }
}
