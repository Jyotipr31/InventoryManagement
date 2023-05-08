package com.gl.inventorymanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.inventorymanagement.entity.Product;
import com.gl.inventorymanagement.entity.Seller;
import com.gl.inventorymanagement.exception.SellerNotFoundException;
import com.gl.inventorymanagement.service.SellerService;

import jakarta.transaction.Transactional;

@RestController
@Transactional
public class SellerController {
	@Autowired
	SellerService sellerService;

	@PostMapping("/add/seller")
	public ResponseEntity<String> addSeller(@RequestBody Seller seller) {
		// return new ResponseEntity<Customer>(customerService.addCustomer(customer),
		// HttpStatus.CREATED);
		sellerService.addSeller(seller);
		return new ResponseEntity<String>("Seller Registered with Seller Id :" + seller.getSellerId(),
				HttpStatus.ACCEPTED);
	}

	@GetMapping("/get/selller")
	public ResponseEntity<List<Seller>> getAllSeller() {
		return new ResponseEntity<List<Seller>>(sellerService.getAllSellers(), HttpStatus.OK);
	}

	@PutMapping("/update/seller")
	public ResponseEntity<String> updateSeller(@RequestBody Seller seller) {
		Optional<Seller> seller2 = sellerService.findSeller(seller.getSellerId());

		if(seller2.get()==null) {
			throw new SellerNotFoundException("SellerId not found"+seller.getSellerId());
		}
		if (seller2.isPresent()) {
			sellerService.updateSeller(seller);
			return new ResponseEntity<String>("Seller Updated with Seller Id :" + seller2.get().getSellerId(),
					HttpStatus.ACCEPTED);

		}
		return new ResponseEntity<String>("Seller Not Found", HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/delete/seller")
	public ResponseEntity<String> deleteSeller(@RequestParam int id) {
		Optional<Seller> seller2 = sellerService.findSeller(id);

		if (seller2.isPresent()) {
			sellerService.deleteSeller(id);
			return new ResponseEntity<String>("Seller deleted with Seller Id :" + seller2.get().getSellerId(),
					HttpStatus.ACCEPTED);

		}
		return new ResponseEntity<String>("Seller Not Found", HttpStatus.NO_CONTENT);
	}

	@GetMapping("/get/sellerById")
	public Seller getSellerById(@RequestParam int id) {
		Optional<Seller> seller2 = sellerService.findSeller(id);
		if (seller2.isPresent()) {
			return seller2.get();
		}
		return null;

	}

}
