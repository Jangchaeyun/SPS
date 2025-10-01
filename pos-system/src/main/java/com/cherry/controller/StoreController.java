package com.cherry.controller;

import com.cherry.exceptions.UserException;
import com.cherry.modal.Store;
import com.cherry.modal.User;
import com.cherry.payload.dto.StoreDTO;
import com.cherry.service.StoreService;
import com.cherry.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/store")
public class StoreController {
    private final StoreService storeService;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<StoreDTO> createStore(@RequestBody StoreDTO storeDTO,
                                                @RequestHeader("Authorization") String jwt) throws UserException {
        User user = userService.getUserFromJwtToken(jwt);
        return ResponseEntity.ok(storeService.createStore(storeDTO, user));
    }

    @GetMapping("{id}")
    public ResponseEntity<StoreDTO> getStoreById(
            @PathVariable Long id,
            @RequestHeader("Authorization") String jwt) throws Exception {
        return ResponseEntity.ok(storeService.getStoreById(id));
    }

    @GetMapping()
    public ResponseEntity<List<StoreDTO>> getAllStore(
            @RequestHeader("Authorization") String jwt) throws Exception {
        return ResponseEntity.ok(storeService.getAllStores());
    }
}
