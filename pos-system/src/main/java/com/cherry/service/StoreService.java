package com.cherry.service;

import com.cherry.exceptions.UserException;
import com.cherry.modal.Store;
import com.cherry.modal.StoreStatus;
import com.cherry.modal.User;
import com.cherry.payload.dto.StoreDTO;

import java.util.List;

public interface StoreService {
    StoreDTO createStore(StoreDTO storeDTO, User user);
    StoreDTO getStoreById(Long id) throws Exception;
    List<StoreDTO> getAllStores();
    Store getStoreByAdmin() throws Exception, UserException;
    StoreDTO updateStore(Long id, StoreDTO storeDTO) throws Exception, UserException;
    void deleteStore(Long id) throws UserException, Exception;
    StoreDTO getStoreByEmployee() throws UserException, Exception;
    StoreDTO moderateStore(Long id, StoreStatus status) throws Exception;

}
