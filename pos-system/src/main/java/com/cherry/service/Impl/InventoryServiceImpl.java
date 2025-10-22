package com.cherry.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cherry.mapper.InventoryMapper;
import com.cherry.modal.Branch;
import com.cherry.modal.Inventory;
import com.cherry.modal.Product;
import com.cherry.payload.dto.InventoryDTO;
import com.cherry.repository.BranchRepository;
import com.cherry.repository.InventoryRepository;
import com.cherry.repository.ProductRepository;
import com.cherry.service.InventoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService  {

	private final InventoryRepository inventoryRepository;
	private final BranchRepository branchRepository;
	private final ProductRepository productRepository;
	
	@Override
	public InventoryDTO createInventory(InventoryDTO inventoryDTO) throws Exception {
		Branch branch = branchRepository.findById(inventoryDTO.getBrachId()).orElseThrow(
				() -> new Exception("branch not exist...")
		);
		Product product =  productRepository.findById(inventoryDTO.getProductId()).orElseThrow(
				() -> new Exception("product not exist...")
		);
		
		Inventory inventory = InventoryMapper.toEntity(inventoryDTO, branch, product);
		Inventory savedInventory = inventoryRepository.save(inventory);
		return InventoryMapper.toDTO(savedInventory);
	}

	@Override
	public InventoryDTO updateInventory(Long id, InventoryDTO inventoryDTO) throws Exception {
		Inventory inventory = inventoryRepository.findById(id).orElseThrow(
				() -> new Exception("inventory not found")
		);
		inventory.setQuantity(inventoryDTO.getQuantity());
		
		Inventory updatedInventory = inventoryRepository.save(inventory);
		return InventoryMapper.toDTO(updatedInventory);
	}

	@Override
	public void deleteInventory(Long id) throws Exception {
		Inventory inventory = inventoryRepository.findById(id).orElseThrow(
				() -> new Exception("inventory not found")
		);
		inventoryRepository.delete(inventory);
	}

	@Override
	public InventoryDTO getInvetoryById(Long id) throws Exception {
		Inventory inventory = inventoryRepository.findById(id).orElseThrow(
				() -> new Exception("inventory not found")
		);
		
		return InventoryMapper.toDTO(inventory);
	}

	@Override
	public InventoryDTO getInventoryByProductIdAndBranchId(Long productId, Long branchId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InventoryDTO> getAllInventoryBranchId(Long branchId) {
		// TODO Auto-generated method stub
		return null;
	}

}
