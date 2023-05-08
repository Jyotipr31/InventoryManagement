//package com.gl.inventorymanagement.entity;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.data.annotation.CreatedDate;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name="orders")
//public class Order {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int orderId;
//	@CreatedDate
//	private LocalDate orderTime;
//	private int totalPrice;
//	
//	@OneToMany(mappedBy="order",cascade = CascadeType.ALL)
//	private List<OrderProduct> orderProducts=new ArrayList<>();
//}
