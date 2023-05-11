package com.gl.inventorymanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.inventorymanagement.entity.Customer;
import com.gl.inventorymanagement.entity.Seller;
import com.gl.inventorymanagement.entity.Admin;
import com.gl.inventorymanagement.service.CustomerService;
import com.gl.inventorymanagement.service.SellerService;
import com.gl.inventorymanagement.service.UserService;

import jakarta.validation.Valid;



@RestController
public class RegisterController {
	@Autowired
	UserService userService;
	@Autowired
	SellerService sellerService;
	
	@Autowired
	CustomerService customerService;
	@PostMapping("/register/admin")
	//@PreAuthorize("ROLE_ADMIN")
	public ResponseEntity<String> register( @RequestBody Admin admin) {
		//return new ResponseEntity<Admin>(adminService.registerAdmin(admin),HttpStatus.CREATED);
		userService.registerAdmin(admin);
		return new ResponseEntity<String>("Customer Registered with User Id :" + admin.getUserId(),
				HttpStatus.ACCEPTED);
	}

	@PostMapping("/register/seller")
	public ResponseEntity<String> addSeller(@RequestBody Seller seller) {
		// return new ResponseEntity<Customer>(customerService.addCustomer(customer),
		// HttpStatus.CREATED);
		sellerService.addSeller(seller);
		return new ResponseEntity<String>("Seller Registered with Seller Id :" + seller.getSellerId(),
				HttpStatus.ACCEPTED);
	}
	@PostMapping("/register/customer")
	public ResponseEntity<String> registerCustomer(@Valid @RequestBody Customer customer) {
		//return new ResponseEntity<Admin>(adminService.registerAdmin(admin),HttpStatus.CREATED);
		Customer customer1 = customerService.addCustomer(customer);
		return new ResponseEntity<String>("Customer Registered with User Id :" + customer1.getId(),
				HttpStatus.ACCEPTED);
	}
	
//	@PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody User user,@RequestParam String role) {
//        // Check if the user is registered by querying the database
//        User user1 = userService.authenticate(user);
//        if (user1 == null) {
//            //return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong credentials.Please try again!!!");
//        	
//        	return new ResponseEntity<String>("Wrong credentials.Please try again!!!" ,
//    				HttpStatus.ACCEPTED);
//        }
//        if(role=="admin")
//        return ResponseEntity.ok(" Admin Login successful");
//        else {
//        	 return ResponseEntity.ok(" User Login successful");
//        }
//    }
}


