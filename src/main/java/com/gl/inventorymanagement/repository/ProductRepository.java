package com.gl.inventorymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gl.inventorymanagement.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Modifying
	@Query("UPDATE Product p SET p.quantity = :quantity WHERE p.id = :id")
	void updateQuantity(@Param("id") int id, @Param("quantity") int quantity);
	
	@Modifying
	@Query("UPDATE Product p SET p.description = :description WHERE p.id = :id")
	void updateDescription(@Param("id") int id, @Param("description") String description);
	
	@Modifying
	@Query("UPDATE Product p SET p.location = :location WHERE p.id = :id")
	void updateLocation(@Param("id") int id, @Param("location") String location);
	
}
