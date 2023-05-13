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
//	public void updateProduct(Product product) {
//		 productRepository.save(product);
//	}
	
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
	
	public void updatePrice(int id, int price) {
		productRepository.updatePrice(id,price);
	}
	public void updateCategory(int id, String category) {
		productRepository.updateCategory(id, category);
	}
	public void deleteProduct(int id) {
		 productRepository.deleteById(id);
	}
	
	public Product updateProduct(Product updatedProduct, int id){
		Optional<Product> optionalOldProduct = productRepository.findById(id);
		if(optionalOldProduct.isEmpty()) {
			return null;
		}
		Product oldProduct = optionalOldProduct.get();
		if(updatedProduct.getCategory() != null)
			oldProduct.setCategory(updatedProduct.getCategory());
		if(updatedProduct.getDescription() != null)
			oldProduct.setDescription(updatedProduct.getDescription());
		if(updatedProduct.getLocation() != null)
			oldProduct.setLocation(updatedProduct.getLocation());
		if(updatedProduct.getName() != null)
			oldProduct.setName(updatedProduct.getName());
		if(updatedProduct.getQuantity() != null)
			oldProduct.setQuantity(updatedProduct.getQuantity());
		if(updatedProduct.getSeller() != null)
			oldProduct.setSeller(updatedProduct.getSeller());
		if(updatedProduct.getUnitPrice() != null)
			oldProduct.setUnitPrice(updatedProduct.getUnitPrice());
		if(updatedProduct.getWeight() != null)
			oldProduct.setWeight(updatedProduct.getWeight());
		
		return productRepository.save(oldProduct);
		
	}
}
