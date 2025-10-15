package com.cherry.service.Impl;

import com.cherry.modal.User;
import com.cherry.payload.dto.BranchDTO;
import com.cherry.repository.BranchRepository;
import com.cherry.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {
    private final BranchRepository branchRepository;

    @Override
    public BranchDTO createBranch(BranchDTO branchDTO, User user) {
        return null;
    }

    @Override
    public BranchDTO updateBranch(Long id, BranchDTO branchDTO, User user) {
        return null;
    }

    @Override
    public BranchDTO deleteBranch(Long id) {
        return null;
    }

    @Override
    public List<BranchDTO> getAllBranchesByStoreId(Long storeId) {
        return List.of();
    }

    @Override
    public BranchDTO getBranchById(Long id) {
        return null;
    }
}
