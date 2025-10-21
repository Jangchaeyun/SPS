package com.cherry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cherry.modal.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
	Inventory findByProductIdAndBranchId(Long productId, Long branchId);
	List<Inventory> findByBranchId(Long branchId);
}