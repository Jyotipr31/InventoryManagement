package com.gl.inventorymanagement.entity;

import java.util.List;
import java.util.function.LongFunction;

import io.micrometer.common.lang.NonNull;
import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderProductId;
	
	@NotNull(message="quantity can not be null")
	private int quantity;
	private Long price;

	@OneToOne
	@JoinColumn(name = "product_id")
	private Product product;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="Customer_id")
	private Customer customer;
}
