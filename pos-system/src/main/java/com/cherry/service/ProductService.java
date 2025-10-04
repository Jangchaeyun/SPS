package com.cherry.service;

import com.cherry.modal.User;
import com.cherry.payload.dto.ProductDTO;

public interface ProductService {
    ProductDTO createProduct(ProductDTO productDTO, User user);
}
