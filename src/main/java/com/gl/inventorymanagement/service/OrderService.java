package com.gl.inventorymanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gl.inventorymanagement.entity.Order;
import com.gl.inventorymanagement.entity.Seller;
import com.gl.inventorymanagement.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	public Order addOrder(Order order) {
		return orderRepository.save(order);
	}
	
   public List<Order> getAllOrder() {
		
		return  orderRepository.findAll();
	}
//	public List<Integer> getAllCustomerIds() {
//		return getAllCustomerIds();
//	}
//	
//	public List<Integer> getAllProductIds() {
//		return getAllProductIds();
//	}
	
	
}
