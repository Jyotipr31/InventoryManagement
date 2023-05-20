package com.gl.inventorymanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.inventorymanagement.entity.Product;
import com.gl.inventorymanagement.entity.Seller;
import com.gl.inventorymanagement.exception.ProductNotFoundException;
import com.gl.inventorymanagement.exception.SellerNotFoundException;
import com.gl.inventorymanagement.repository.SellerRepository;

@Service
public class SellerService {
	@Autowired
    private SellerRepository sellerRepository;
	
	public Seller addSeller(Seller  seller) {
		 return sellerRepository.save(seller); 
	}

	public List<Seller> getAllSellers() {
		
		return  sellerRepository.findAll();
	}
	public void updateSeller(Seller seller) {
		 sellerRepository.save(seller);
	}
	
	public Optional<Seller> findSeller(int id) {
		Optional<Seller> seller = sellerRepository.findById(id);
		if(seller==null)
			throw new SellerNotFoundException();
		return sellerRepository.findById(id);
	}
	
	public void deleteSeller(int id) {
		Optional<Seller> seller = sellerRepository.findById(id);
		if(seller==null)
			throw new SellerNotFoundException();
		 sellerRepository.deleteById(id);
	}
}
