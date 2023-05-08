//package com.gl.inventorymanagement.controller;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.hibernate.validator.internal.engine.groups.ValidationOrderGenerator;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.gl.inventorymanagement.entity.Order;
//import com.gl.inventorymanagement.entity.OrderProduct;
//import com.gl.inventorymanagement.entity.Product;
//import com.gl.inventorymanagement.service.OrderProductService;
//import com.gl.inventorymanagement.service.OrderService;
//import com.gl.inventorymanagement.service.ProductService;
//
//import jakarta.transaction.Transactional;
//
//@RestController
//@Transactional
//public class OrderController {
//
//	@Autowired
//	OrderService orderService;
//	@Autowired
//	ProductService productService;
//	@Autowired
//	OrderProductService orderProductService;
////	@PostMapping("/add/order")
////	public ResponseEntity<Order> register( @RequestBody Order order,@RequestBody List<OrderProduct> products) {
////
////		Order order1 = new Order();
////		order.setOrderTime(LocalDate.now());
////		order.setTotalPrice(order.getTotalPrice());
////		order.setOrderProducts(products);
////		orderService.addOrder(order1);
////		order.s
////		
////		for (OrderProduct item : order.getOrderProducts()) {
////		    // Create a new OrderProduct object for each item
////		    OrderProduct orderProduct = new OrderProduct();
////		    orderProduct.setOrder(order1);
////		    orderProduct.setProductId(item.getProductId());
////		    orderProduct.setQuantity(item.getQuantity()); 
////		    Product product1= productService.findProduct(item.getProductId()).get();
////		    Long price= product1.getUnitPrice();
////		    orderProduct.setPrice(price);
////
////		    // Save the order product to the database
////		    orderProductService.addOrderProduct(orderProduct);
////		}
////		return new ResponseEntity<Order>(orderService.addOrder(order),HttpStatus.CREATED);
////	}
//	
//	@PostMapping("/addorder")
//	public ResponseEntity<String> addOrder(@ResponseBody Order order,@PathVariable Long id){
//		
//		
//		
//			Product product = productService.findProduct(id).get();
//			
//		
//		
//		oProduct.setProduct(product);
//		oProduct.setOrder(order);
//	
//		
//	
//		
//		
//		
//		
//		
//		
//	}
//	
//}
