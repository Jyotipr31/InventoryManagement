package com.gl.inventorymanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.inventorymanagement.entity.Product;
import com.gl.inventorymanagement.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
       private ProductRepository productRepository;
	public Product addProduct(Product product) {
		 return productRepository.save(product); 
	}
//	public void placeOrderUpdateQuantity(Product product, int quantity) {
//		int newQuantity= product.getQuantity()-quantity;
//		 productRepository.updateQuantity(product.getId(), newQuantity);
//	}
//	
//	public void cancelOrderUdateQuantity(Product product, int quantity) {
//		int newQuantity= product.getQuantity()+quantity;
//		 productRepository.updateQuantity(product.getId(), newQuantity);
//	}
	
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

		return productRepository.findById(id);
	}
	
	public void updateDescription(int id, String description) {
		productRepository.updateDescription(id,description);
	}
	
	public void updateLocation(int id, String location) {
		productRepository.updateLocation(id,location);
	}
	
	public void deleteProduct(int id) {
		 productRepository.deleteById(id);
	}
}
