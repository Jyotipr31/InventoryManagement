package com.gl.inventorymanagement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.interceptor.CacheOperationInvoker.ThrowableWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.inventorymanagement.entity.Product;
import com.gl.inventorymanagement.entity.Seller;
import com.gl.inventorymanagement.exception.ResourceNotFoundException;
import com.gl.inventorymanagement.service.ProductService;
import com.gl.inventorymanagement.service.SellerService;

import jakarta.persistence.Entity;
import jakarta.transaction.Transactional;

@RestController
@Transactional
//@RequestMapping("api-product")
public class ProductController {	
	@Autowired
	ProductService productService;
	@Autowired
	SellerService sellerService;
	
	

	@PostMapping("api-product/add/product/{id}")
	public ResponseEntity<String> addProduct( @RequestBody Product product,@PathVariable int id) {
		
		
		try {
			Seller seller=sellerService.findSeller(id).get();
			List<Seller> sellers=new ArrayList<>();
			sellers.add(seller);
			product.setSeller(sellers);
			productService.addProduct(product);
		} catch (Exception e) {
			if(e!=null)
				throw new ResourceNotFoundException();
		}
		
		
		return new ResponseEntity<String>("Product ",HttpStatus.CREATED);
	}
	
	@GetMapping("api-all/get/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		try {
			return new ResponseEntity<List<Product>>(productService.getAllProducts(),HttpStatus.OK);
		} catch (Exception e) {
			if(e!=null)
				throw new ResourceNotFoundException();
		}
		return new ResponseEntity<List<Product>>(productService.getAllProducts(),HttpStatus.OK);
		
	}
	
	@GetMapping("api-product/get/productById/{id}")
	public ResponseEntity<Product> getAllProductsById(@PathVariable int id) {

		try {
			return new ResponseEntity<Product>(productService.findProductById(id).get(),HttpStatus.OK);
		} catch (Exception e) {
			if(e!=null) { 
				throw new ResourceNotFoundException();
			}
		}
		return new ResponseEntity<Product>(productService.findProductById(id).get(),HttpStatus.OK);
//		return productService.findProductById(id).get();
	}
	
	//@PreAuthorize("hasAuthority('ROLE_SELLER')")
//	@PutMapping("/update/product")
//	public ResponseEntity<String> updateProduct( @RequestBody Product product) {
//		try {
//			Optional<Product> product2 = productService.findProductById(product.getId());
//			Seller seller=product2.get().getSeller();
//			product.setSeller(seller);
//		} catch (Exception e) {
//			if(e != null) {
//				throw new ResourceNotFoundException();
//			}
//		}
//		Optional<Product> product2 = productService.findProductById(product.getId());
//		Seller seller=product2.get().getSeller();
//		product.setSeller(seller);
//		
//		if(product2.isPresent()) {
//			productService.updateProduct(product);
//			System.out.println("product updated");
//			return new ResponseEntity<String>("Product Updated with Product Id :" + product2.get().getId(), HttpStatus.ACCEPTED);
//		  
//	}
//		else {
//			throw new ResourceNotFoundException();
//		}
//	//	return new ResponseEntity<String>("Product Not Found" , HttpStatus.NO_CONTENT);
//}
	//@PreAuthorize("hasAuthority('ROLE_SELLER')")
	@PutMapping("api-product/update/description")
	public ResponseEntity<String> updateDescription( @RequestParam int id,@RequestParam String description) {
		Optional<Product> product2 = productService.findProductById(id);
		
		if(product2.isPresent()) {
			productService.updateDescription(id, description);
			return new ResponseEntity<String>("Description Updated with Product Id :" + product2.get().getId(), HttpStatus.ACCEPTED);
		  
	}
		else {
			throw new ResourceNotFoundException();
		}
	//	return new ResponseEntity<String>("Product Not Found" , HttpStatus.NO_CONTENT);
}
	
	@PutMapping("api-product/update/quantity")
	public ResponseEntity<String> updateQuantity( @RequestParam int id,@RequestParam int quantity) {
		Optional<Product> product2 = productService.findProductById(id);	
		if(product2.isPresent()) {
			productService.updateQuantity(id, quantity);
			return new ResponseEntity<String>("quantity Updated with Product Id :" + product2.get().getId(), HttpStatus.ACCEPTED);
		  
	}
		else {
			throw new ResourceNotFoundException();
		}
	//	return new ResponseEntity<String>("Product Not Found" , HttpStatus.NO_CONTENT);
}
	//@PreAuthorize("hasAuthority('ROLE_SELLER')")
	@PutMapping("api-product/update/price")
	public ResponseEntity<String> updatePrice( @RequestParam int id,@RequestParam int price) {
		Optional<Product> product2 = productService.findProductById(id);	
		if(product2.isPresent()) {
			productService.updatePrice(id, price);
			return new ResponseEntity<String>("price Updated with Product Id :" + product2.get().getId(), HttpStatus.ACCEPTED);
		  
	}
		else {
			throw new ResourceNotFoundException();
		}
//		return new ResponseEntity<String>("Product Not Found" , HttpStatus.NO_CONTENT);
}
	@PutMapping("api-product/update/location")
	public ResponseEntity<String> updateLocation( @RequestParam int id,@RequestParam String location) {
		Optional<Product> product2 = productService.findProductById(id);	
		if(product2.isPresent()) {
			productService.updateLocation(id, location);
			return new ResponseEntity<String>("Location Updated with Product Id :" + product2.get().getId(), HttpStatus.ACCEPTED);
		  
	}
		else {
			throw new ResourceNotFoundException();
		}
//		return new ResponseEntity<String>("Product Not Found" , HttpStatus.NO_CONTENT);
}
	
	@PutMapping("api-product/update/category")
	public ResponseEntity<String> updateCategory( @RequestParam int id,@RequestParam String category) {
		Optional<Product> product2 = productService.findProductById(id);	
		if(product2.isPresent()) {
			productService.updateCategory(id, category);
			return new ResponseEntity<String>("Category Updated with Product Id :" + product2.get().getId(), HttpStatus.ACCEPTED);
		  
	}
		else {
			throw new ResourceNotFoundException();
		}
//		return new ResponseEntity<String>("Product Not Found" , HttpStatus.NO_CONTENT);
}
	
	//@PreAuthorize("hasAuthority('ROLE_SELLER')")
	@DeleteMapping("api-product/delete/product")
	public ResponseEntity<String> deleteCustomer(@RequestParam int id) {
		Optional<Product> product2 = productService.findProductById(id);

		if (product2.isPresent()) {
			productService.deleteProduct(id);
			return new ResponseEntity<String>("Customer deleted with Customer Id :" + product2.get().getId(),
					HttpStatus.ACCEPTED);

		}
		else {
			throw new ResourceNotFoundException();
		}
		//return new ResponseEntity<String>("Customer Not Found", HttpStatus.NO_CONTENT);
	}
}
