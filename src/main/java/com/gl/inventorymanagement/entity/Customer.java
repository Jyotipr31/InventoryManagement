package com.gl.inventorymanagement.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Size(min=4 , message = "Name should be atleast 4 characters")
	private String username;
	private String password;
	private String email;
	private String roles;
	private String gender;
	private String address;
	@OneToMany(mappedBy = "customer")
	private List<OrderItem> orderProducts;
	
}
