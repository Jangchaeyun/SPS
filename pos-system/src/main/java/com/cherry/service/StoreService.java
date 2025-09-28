package com.cherry.service;

import com.cherry.modal.Store;
import com.cherry.modal.User;
import com.cherry.payload.dto.StoreDTO;

import java.util.List;

public interface StoreService {
    StoreDTO createStore(StoreDTO storeDTO, User user);
    Store getStoreById(Long id);
    List<StoreDTO> getAllStores();
    Store getStoreByAdmin();
    StoreDTO updateStore(StoreDTO storeDTO, User user);
    StoreDTO deleteStore(Long id);
    StoreDTO getStoreByEmployee();
}
