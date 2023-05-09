package com.gl.inventorymanagement.entity;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="seller")
public class Seller {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sellerId;
	private String location;
	//@Size(min=4 , message = "Name should be atleast 4 characters")
	private String contactPerson;
	//@Size(min=10 , message = " Contact number should be of 10 digits")
	private long contactNumber;
	private String type;
	@OneToMany(mappedBy = "seller")
    private List<Product> product;	
}
