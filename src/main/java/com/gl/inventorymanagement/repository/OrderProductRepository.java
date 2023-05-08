package com.gl.inventorymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gl.inventorymanagement.entity.OrderProduct;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Integer> {

}
