package com.gl.inventorymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gl.inventorymanagement.entity.Customer;
import com.gl.inventorymanagement.entity.Order;
import com.gl.inventorymanagement.entity.OrderItem;
import com.gl.inventorymanagement.entity.Product;
import com.gl.inventorymanagement.exception.SellerNotFoundException;
import com.gl.inventorymanagement.service.CustomerService;
import com.gl.inventorymanagement.service.OrderItemService;
import com.gl.inventorymanagement.service.ProductService;

@RestController
public class OrderItemController {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	OrderItemService orderProductService;
	
@PostMapping("api-customer/placeorder/{ids}")
public ResponseEntity<String> placeOrder(@RequestBody OrderItem orderItem,@PathVariable List<Integer> ids){
	Customer customer = customerService.findCustomerById(orderItem.getCustomer().getId()).get();
	System.out.println(customer.getUsername());
	for(int id : ids) {
		System.out.println(id);
		Product product = productService.findProductById(id).get();
		int orderedQuantity = orderItem.getQuantity();
		if(product.getQuantity()>orderedQuantity) {
		int remaningQuantity = product.getQuantity()-orderedQuantity;
		product.setQuantity(remaningQuantity);
		}
		orderItem.setProduct(product);
		productService.addProduct(product);
	}
	orderItem.setCustomer(customer);
	orderProductService.addOrderProduct(orderItem);
	System.out.println("done");
	return new ResponseEntity<String>("Completed " , HttpStatus.ACCEPTED);
	
}
@GetMapping("api-all/getAllOrderProducts")
public ResponseEntity<List<OrderItem>> getAllOrderProducts() {
	try {
		return new ResponseEntity<List<OrderItem>>(orderProductService.getAllOrderProduct(), HttpStatus.OK);
	} catch (Exception e) {
		if(e!=null)
			throw new SellerNotFoundException();
	}
	return new ResponseEntity<List<OrderItem>>(orderProductService.getAllOrderProduct(), HttpStatus.OK);
}
}
