package com.cherry.service;

import com.cherry.modal.User;
import com.cherry.payload.dto.BranchDTO;

import java.util.List;

public interface BranchService {
    BranchDTO createBranch(BranchDTO branchDTO, User user);
    BranchDTO updateBranch(Long id, BranchDTO branchDTO, User user);
    BranchDTO deleteBranch(Long id);
    List<BranchDTO> getAllBranchesByStoreId(Long storeId);
    BranchDTO getBranchById(Long id);
}
