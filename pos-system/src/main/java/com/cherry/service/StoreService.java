package com.cherry.service;

import com.cherry.exceptions.UserException;
import com.cherry.modal.Store;
import com.cherry.modal.User;
import com.cherry.payload.dto.StoreDTO;

import java.util.List;

public interface StoreService {
    StoreDTO createStore(StoreDTO storeDTO, User user);
    StoreDTO getStoreById(Long id) throws Exception;
    List<StoreDTO> getAllStores();
    Store getStoreByAdmin() throws UserException;
    StoreDTO updateStore(StoreDTO storeDTO, User user);
    StoreDTO deleteStore(Long id);
    StoreDTO getStoreByEmployee();
}
