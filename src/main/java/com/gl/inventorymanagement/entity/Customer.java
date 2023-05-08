package com.gl.inventorymanagement.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	private int id;
	private String name;
	@OneToMany(mappedBy = "customer")
	private List<OrderProduct> orderProducts;
}
