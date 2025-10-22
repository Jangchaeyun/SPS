package com.cherry.service;

import java.util.List;

import com.cherry.payload.dto.InventoryDTO;

public interface InventoryService {
	InventoryDTO createInventory(InventoryDTO inventoryDTO) throws Exception;
	InventoryDTO updateInventory(Long id, InventoryDTO inventoryDTO) throws Exception;
	void deleteInventory(Long id) throws Exception;
	InventoryDTO getInvetoryById(Long id) throws Exception;
	InventoryDTO getInventoryByProductIdAndBranchId(Long productId, Long branchId);
	List<InventoryDTO> getAllInventoryBranchId(Long branchId);
}
