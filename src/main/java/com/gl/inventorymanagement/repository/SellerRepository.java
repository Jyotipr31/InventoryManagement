package com.gl.inventorymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gl.inventorymanagement.entity.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller,Integer> {	
//	 @Modifying 
//    @Query("UPDATE Customer c SET c.username = :username, c.email = :email, c.phoneNumber= :phoneNumber where c.customerId= :customerId")
//      void updateCustomer(@Param("customerId") int customerId,@Param("username") String username, @Param("email") String email, @Param("phoneNumber") long phoneNumber
//    		  );
}
