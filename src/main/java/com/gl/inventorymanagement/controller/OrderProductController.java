package com.gl.inventorymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gl.inventorymanagement.entity.Customer;
import com.gl.inventorymanagement.entity.OrderProduct;
import com.gl.inventorymanagement.entity.Product;
import com.gl.inventorymanagement.service.CustomerService;
import com.gl.inventorymanagement.service.OrderProductService;
import com.gl.inventorymanagement.service.ProductService;

@RestController
public class OrderProductController {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	OrderProductService orderProductService;
	
@PostMapping("/placeorder/{ids}")
public ResponseEntity<String> placeOrder(@RequestBody OrderProduct orderProduct,@PathVariable List<Integer> ids){
	Customer customer = customerService.findCustomerById(orderProduct.getCustomer().getId()).get();
	System.out.println(customer.getName());
	for(int id : ids) {
		System.out.println(id);
		Product product = productService.findProductById(id).get();
		int orderedQuantity = orderProduct.getQuantity();
		if(product.getQuantity()>orderedQuantity) {
		int remaningQuantity = product.getQuantity()-orderedQuantity;
		product.setQuantity(remaningQuantity);
		}
		orderProduct.setProduct(product);
		productService.addProduct(product);
	}
	orderProduct.setCustomer(customer);
	orderProductService.addOrderProduct(orderProduct);
	System.out.println("done");
	return new ResponseEntity<String>("Completed " , HttpStatus.ACCEPTED);
	
}
}
