package com.gl.inventorymanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.inventorymanagement.entity.OrderProduct;
import com.gl.inventorymanagement.repository.OrderProductRepository;

@Service
public class OrderProductService {

	@Autowired
	OrderProductRepository orderProductRepository;
	public  OrderProduct addOrderProduct(OrderProduct orderProduct) {
		return orderProductRepository.save(orderProduct);
	}
}
