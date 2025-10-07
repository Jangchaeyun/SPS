package com.cherry.service;

import com.cherry.modal.User;
import com.cherry.payload.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO createProduct(ProductDTO productDTO, User user) throws Exception;
    ProductDTO updateProduct(Long id, ProductDTO productDTO, User user) throws Exception;
    void deleteProduct(Long id, User user) throws Exception;
    List<ProductDTO> getProductsByStoreId(Long storeId, User user);
    List<ProductDTO> searchProductKeyword(Long storeId, String keyword);
}
