package com.gl.inventorymanagement.entity;

import java.sql.Date;
import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderItemId;
	
	@NotNull(message="quantity can not be null")
	private int quantity;
	private Long price;
	@CreationTimestamp
	@Column(name = "created_at")
    private LocalDate createdAt;
	
//	
////	@Temporal(TemporalType.DATE)
//	private Date dateTime;

	@OneToOne
	@JoinColumn(name = "product_id")
	private Product product;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="Customer_id")
	private Customer customer;
}
