package com.gl.inventorymanagement.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
	private String contactPerson;
	private long contactNumber;
	private String type;
//	@OneToOne(mappedBy = "seller")
//    private Product product;	
}
