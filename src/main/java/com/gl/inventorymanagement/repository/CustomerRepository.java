package com.gl.inventorymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.inventorymanagement.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
