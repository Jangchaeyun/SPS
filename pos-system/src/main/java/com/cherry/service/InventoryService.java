package com.cherry.service;

import java.util.List;

import com.cherry.payload.dto.InventoryDTO;

public interface InventoryService {
	InventoryDTO createInventory(InventoryDTO inventoryDTO);
	InventoryDTO updateInventory(InventoryDTO inventoryDTO);
	void deleteInventory(Long id);
	InventoryDTO getInvetoryById(Long id);
	InventoryDTO getInventoryByProductIdAndBranchId(Long productId, Long branchId);
	List<InventoryDTO> getAllInventoryBranchId(Long branchId);
}
