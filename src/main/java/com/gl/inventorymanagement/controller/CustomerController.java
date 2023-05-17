package com.gl.inventorymanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.inventorymanagement.entity.Customer;
import com.gl.inventorymanagement.entity.Seller;
import com.gl.inventorymanagement.exception.SellerNotFoundException;
import com.gl.inventorymanagement.service.CustomerService;

import jakarta.validation.Valid;

@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;
	@PostMapping("api-all/registerCustomer")
	public ResponseEntity<String> registerCustomer(@Valid @RequestBody Customer customer) {
				
		Customer customer1 = customerService.registerCustomer(customer);
		return new ResponseEntity<String>("Customer Registered with User Id :" + customer1.getId(),
				HttpStatus.ACCEPTED);
	}
	
	@GetMapping("api-admin/get/customerById/{id}")
	public Customer getCustomerById(@PathVariable int id) {
		Optional<Customer> customer = customerService.findCustomerById(id);
		if (customer.isPresent()) {
			return customer.get();
		}
		else {
			throw new SellerNotFoundException();
		}
		//return null;

	}

	@GetMapping("api-admin/get/allCustomers")
	public List<Customer>  getAllCustomers() {
		
		return customerService.getAllCustomers();

	}
	@GetMapping("api-admin/get/customerByGender")
	public List<Customer> getCustomerByGender(@RequestParam String gender) {
		
		return customerService.getCustomerByGender(gender);

	}
}
