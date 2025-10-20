package com.cherry.mapper;

import com.cherry.modal.Inventory;
import com.cherry.payload.dto.InventoryDTO;

public class InventoryMapper {
	public static InventoryDTO toDTO(Inventory inventory) {
		return InventoryDTO.builder()
				.id(inventory.getId())
				.brachId(inventory.getBranch().getId())
				.productId(inventory.getProduct().getId())
				.product(ProductMapper.toDTO(inventory.getProduct()))
				.quantity(inventory.getQuantity())
				.build();
	}
}
