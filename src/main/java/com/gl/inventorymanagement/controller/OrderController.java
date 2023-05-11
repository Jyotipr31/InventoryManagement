package com.gl.inventorymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gl.inventorymanagement.entity.Order;
import com.gl.inventorymanagement.entity.Seller;
import com.gl.inventorymanagement.exception.SellerNotFoundException;
import com.gl.inventorymanagement.service.OrderItemService;
import com.gl.inventorymanagement.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderItemService orderProductService;
	@Autowired
	OrderService orderService;
	@PostMapping("/add/order")
	public ResponseEntity<String> addOrder(@RequestBody Order order) {
		
		List<Object[]> result = orderProductService.findTotalPrice();
		Long price=0L;
		for (Object[] row : result) {
			 price=(Long) row[3];
		}
		order.setTotalPrice(price);
		orderService.addOrder(order);
		return new ResponseEntity<String>("Order Created ",HttpStatus.CREATED);
	}
	
	@GetMapping("api-admin/getCustomer")
	public ResponseEntity<List<Order>> getAllSeller() {
		try {
			return new ResponseEntity<List<Order>>(orderService.getAllOrder(), HttpStatus.OK);
		} catch (Exception e) {
			if(e!=null)
				throw new SellerNotFoundException();
		}
		return new ResponseEntity<List<Order>>(orderService.getAllOrder(), HttpStatus.OK);
	}
}
