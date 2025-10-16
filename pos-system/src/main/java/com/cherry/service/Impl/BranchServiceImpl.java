package com.cherry.service.Impl;

import com.cherry.exceptions.UserException;
import com.cherry.mapper.BranchMapper;
import com.cherry.modal.Branch;
import com.cherry.modal.Store;
import com.cherry.modal.User;
import com.cherry.payload.dto.BranchDTO;
import com.cherry.repository.BranchRepository;
import com.cherry.repository.UserRepository;
import com.cherry.service.BranchService;
import com.cherry.service.UserService;
import com.cherry.service.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {
    private final BranchRepository branchRepository;
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    @Override
    public BranchDTO createBranch(BranchDTO branchDTO, User user) throws UserException {
        User currentUser = userService.getCurrentUser();
        Store store = storeRepository.findByStoreAdminId(currentUser.getId());

        Branch branch = BranchMapper.toEntity(branchDTO, store);
        Branch savedBranch = branchRepository.save(branch);
        return BranchMapper.toBranchDTO(savedBranch);
    }

    @Override
    public BranchDTO updateBranch(Long id, BranchDTO branchDTO, User user) throws Exception {
        Branch exiting = branchRepository.findById(id).orElseThrow(
                () -> new Exception("branch not exist...")
        );

        exiting.setName(branchDTO.getName());
        exiting.setWorkingDays(branchDTO.getWorkingDays());
        exiting.setEmail(branchDTO.getEmail());
        exiting.setPhone(branchDTO.getPhone());
        exiting.setAddress(branchDTO.getAddress());
        exiting.setOpenTime(branchDTO.getOpenTime());
        exiting.setCloseTime(branchDTO.getCloseTime());
        exiting.setUpdatedAt(LocalDateTime.now());

        Branch updatedBranch = branchRepository.save(exiting);
        return BranchMapper.toBranchDTO(updatedBranch);
    }

    @Override
    public void deleteBranch(Long id) throws Exception {
        Branch exiting = branchRepository.findById(id).orElseThrow(
                () -> new Exception("branch not exist...")
        );
        branchRepository.delete(exiting);
    }

    @Override
    public List<BranchDTO> getAllBranchesByStoreId(Long storeId) {
        List<Branch> branches =  branchRepository.findByStoreId(storeId);
        return branches.stream().map(BranchMapper::toBranchDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BranchDTO getBranchById(Long id) throws Exception {
        Branch exiting = branchRepository.findById(id).orElseThrow(
                () -> new Exception("branch not exist...")
        );
        return BranchMapper.toBranchDTO(exiting);
    }
}
