package com.gl.inventorymanagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.inventorymanagement.entity.Customer;
import com.gl.inventorymanagement.entity.OrderProduct;
import com.gl.inventorymanagement.entity.Product;
import com.gl.inventorymanagement.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	public  Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public Optional<Customer> findCustomerById(int id) {

		return customerRepository.findById(id);
	}
}
