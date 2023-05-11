package com.gl.inventorymanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
import jakarta.validation.Valid;

@RestController
@Transactional
public class SellerController {
	@Autowired
	SellerService sellerService;

	
//	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PostMapping("/add/seller")
	public ResponseEntity<String> addSeller(@Valid @RequestBody Seller seller) {
		// return new ResponseEntity<Customer>(customerService.addCustomer(customer),
		// HttpStatus.CREATED);
		try {
			sellerService.addSeller(seller);
			return new ResponseEntity<String>("Seller Registered with Seller Id :" + seller.getSellerId(),
					HttpStatus.ACCEPTED);
		} catch (Exception e) {
			// TODO: handle exception
			throw new SellerNotFoundException();
		}
		//sellerService.addSeller(seller);
		//return new ResponseEntity<String>("Seller Registered with Seller Id :" + seller.getSellerId(),HttpStatus.ACCEPTED);
	}

//	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("api-seller/get")
	public ResponseEntity<List<Seller>> getAllSeller() {
		try {
			return new ResponseEntity<List<Seller>>(sellerService.getAllSellers(), HttpStatus.OK);
		} catch (Exception e) {
			if(e!=null)
				throw new SellerNotFoundException();
		}
		return new ResponseEntity<List<Seller>>(sellerService.getAllSellers(), HttpStatus.OK);
	}

	//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PutMapping("/update/seller")
	public ResponseEntity<String> updateSeller( @Valid @RequestBody Seller seller) {
		Optional<Seller> seller2 = sellerService.findSeller(seller.getSellerId());

		if(seller2.get()==null) {
			throw new SellerNotFoundException();
		}
		if (seller2.isPresent()) {
			sellerService.updateSeller(seller);
			return new ResponseEntity<String>("Seller Updated with Seller Id :" + seller2.get().getSellerId(),
					HttpStatus.ACCEPTED);

		}
		return new ResponseEntity<String>("Seller Not Found", HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/update/sellerType")
	public ResponseEntity<String> updateType(@RequestParam int id, @RequestParam  String type) {
		Optional<Seller> seller2 = sellerService.findSeller(id);

		if(seller2.get()==null) {
			throw new SellerNotFoundException();
		}
		if (seller2.isPresent()) {
			sellerService.updateType(id,type);
			return new ResponseEntity<String>("Seller type updated :" + seller2.get().getSellerId(),
					HttpStatus.ACCEPTED);

		}
		return new ResponseEntity<String>("Seller Not Found", HttpStatus.NO_CONTENT);
	}

	@PutMapping("/update/sellerLocation")
	public ResponseEntity<String> updateLocation(@RequestParam int id, @RequestParam  String location) {
		Optional<Seller> seller2 = sellerService.findSeller(id);

		if(seller2.get()==null) {
			throw new SellerNotFoundException();
		}
		if (seller2.isPresent()) {
			sellerService.updateType(id,location);
			return new ResponseEntity<String>("Seller type updated :" + seller2.get().getSellerId(),
					HttpStatus.ACCEPTED);

		}
		return new ResponseEntity<String>("Seller Not Found", HttpStatus.NO_CONTENT);
	}
	@PutMapping("/update/sellerName")
	public ResponseEntity<String> updateName(@RequestParam int id, @RequestParam  String name) {
		Optional<Seller> seller2 = sellerService.findSeller(id);

		if(seller2.get()==null) {
			throw new SellerNotFoundException();
		}
		if (seller2.isPresent()) {
			sellerService.updateName(id,name);
			return new ResponseEntity<String>("Seller name updated :" + seller2.get().getSellerId(),
					HttpStatus.ACCEPTED);

		}
		return new ResponseEntity<String>("Seller Not Found", HttpStatus.NO_CONTENT);
	}

//	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@DeleteMapping("/delete/seller")
	public ResponseEntity<String> deleteSeller(@RequestParam int id) {
		Optional<Seller> seller2 = sellerService.findSeller(id);

		if (seller2.isPresent()) {
			sellerService.deleteSeller(id);
			return new ResponseEntity<String>("Seller deleted with Seller Id :" + seller2.get().getSellerId(),
					HttpStatus.ACCEPTED);

		}
		else {
			throw new SellerNotFoundException();
		}
	//	return new ResponseEntity<String>("Seller Not Found", HttpStatus.NO_CONTENT);
	}
    
//	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/get/sellerById")
	public Seller getSellerById(@RequestParam int id) {
		Optional<Seller> seller2 = sellerService.findSeller(id);
		if (seller2.isPresent()) {
			return seller2.get();
		}
		else {
			throw new SellerNotFoundException();
		}
		//return null;

	}
	
	@GetMapping("/get/sellerByType")
	public List<Seller> getSellerByType(@RequestParam String type) {
		List<Seller> sellerList = sellerService.findSellerByType(type);
		if (sellerList!=null) {
			return sellerList;
		}
		else {
			throw new SellerNotFoundException();
		}
		//return null;

	}

	@GetMapping("/get/sellerByLocation")
	public List<Seller> getSellerByLocation(@RequestParam String location) {
		List<Seller> sellerList = sellerService.findSellerByLocation(location);
		if (sellerList!=null) {
			return sellerList;
		}
		else {
			throw new SellerNotFoundException();
		} 

	}

}
