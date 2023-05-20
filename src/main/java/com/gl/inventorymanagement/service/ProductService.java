package com.gl.inventorymanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.inventorymanagement.entity.Product;
import com.gl.inventorymanagement.exception.ProductNotFoundException;
import com.gl.inventorymanagement.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
       private ProductRepository productRepository;
	public Product addProduct(Product product) {
		 return productRepository.save(product); 
	}
	
	public List<Product> getAllProducts() {		
		return  productRepository.findAll();
	}
	public void updateProduct(Product product) {
		 productRepository.save(product);
	}
	
	public void updateQuantity(int id,int quantity) {
		 productRepository.updateQuantity(id,quantity);
	}
	public Optional<Product> findProductById(int id) {

		Optional<Product> prod = productRepository.findById(id);
		if(prod==null) 
			throw new ProductNotFoundException();
		return prod;
	}
	
	public void updateDescription(int id, String description) {
		Optional<Product> prod = productRepository.findById(id);
		if(prod==null)
			throw new ProductNotFoundException();
		productRepository.updateDescription(id,description);
	}
	
	public void updateLocation(int id, String location) {
		Optional<Product> prod = productRepository.findById(id);
		if(prod==null)
			throw new ProductNotFoundException();
		productRepository.updateLocation(id,location);
	}
	
	public void updatePrice(int id, int price) {
		Optional<Product> prod = productRepository.findById(id);
		if(prod==null)
			throw new ProductNotFoundException();
		productRepository.updatePrice(id,price);
	}
	public void deleteProduct(int id) {
		Optional<Product> prod = productRepository.findById(id);
		if(prod==null)
			throw new ProductNotFoundException();
		 productRepository.deleteById(id);
	}
}
