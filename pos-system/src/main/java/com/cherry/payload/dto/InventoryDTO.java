package com.cherry.payload.dto;

import java.time.LocalDateTime;

import com.cherry.modal.Branch;
import com.cherry.modal.Product;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InventoryDTO {
	private Long id;
	
	private Branch branch;
	
	private Long brachId;
	
	private Long productId;
	
	private ProductDTO product;
	
	private Integer quantity;
	
	private LocalDateTime lastUpdate;
}
