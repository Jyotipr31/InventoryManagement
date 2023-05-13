package com.gl.inventorymanagement.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gl.inventorymanagement.entity.Customer;
import com.gl.inventorymanagement.entity.Order;
import com.gl.inventorymanagement.entity.OrderItem;
import com.gl.inventorymanagement.entity.Product;
import com.gl.inventorymanagement.exception.SellerNotFoundException;
import com.gl.inventorymanagement.service.CustomerService;
import com.gl.inventorymanagement.service.OrderItemService;
import com.gl.inventorymanagement.service.OrderService;
import com.gl.inventorymanagement.service.ProductService;

import jakarta.transaction.Transactional;

@RestController
@Transactional
public class OrderItemController {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	OrderItemService orderItemService;
	
//@PostMapping("api-customer/placeorder")
//public ResponseEntity<String> placeOrder(@RequestBody OrderItem orderItem, @RequestParam List<Integer> productIds){
//	Customer customer = customerService.findCustomerById(orderItem.getCustomer().getId()).get();
//
//	for(int id : productIds) {
//		System.out.println(id);
//		Product product = productService.findProductById(id).get();
//		int orderedQuantity = orderItem.getQuantity();
//		if(product.getQuantity()>orderedQuantity) {
//		int remaningQuantity = product.getQuantity()-orderedQuantity;
//		product.setQuantity(remaningQuantity);
//		}
//		orderItem.setProduct(product);
//		productService.addProduct(product);
//	}
//	orderItem.setCustomer(customer);
//	
//	List<Object[]> result = orderItemService.findTotalPrice();
//	Long price=0L;
//	for (Object[] row : result) {
//		 price=(Long) row[3];
//	}
//	Order order=orderItem.getOrder();
//	order.setTotalPrice(price);
//	orderItem.setOrder(order);
//	orderService.addOrder(order);
//	orderItemService.addOrderProduct(orderItem);
//	
//	
//    return new ResponseEntity<String>("Completed " , HttpStatus.ACCEPTED);
//	}

	@PostMapping("api-customer/placeorder/{customerId}")
public ResponseEntity<String> placeOrder(
		@PathVariable int customerId,
        @RequestBody Map<String, List<Integer>> requestData) {
    Customer customer = customerService.findCustomerById(customerId).get();
    Order order = new Order();
    order.setCustomerId(customerId);
    orderService.addOrder(order);
    List<Integer> productIds = requestData.get("productIds");
    List<Integer> quantities = requestData.get("quantities");
    System.out.println(productIds.stream().count());
    System.out.println(quantities.stream().count());
    Long totalPrice = 0L;
    for (int i = 0; i < productIds.size(); i++) {
        Integer productId = productIds.get(i);
        Integer quantity = quantities.get(i);
        Product product = productService.findProductById(productId).get();
        if (product.getQuantity() < quantity) {
            throw new IllegalArgumentException("Product " + productId + " doesn't have enough quantity");
        }
        Long price = product.getUnitPrice() * quantity;
        totalPrice += price;
        product.setQuantity(product.getQuantity() - quantity);
        productService.addProduct(product);
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setQuantity(quantity);
        orderItem.setPrice(product.getUnitPrice());
        orderItem.setCustomer(customer);
        orderItem.setOrder(order);
        orderItemService.addOrderProduct(orderItem);
//        orderItems.add(orderItem);
    }
//    order.setOrderItems(orderItems);
    order.setTotalPrice(totalPrice);
    orderService.addOrder(order);
    
    
    return ResponseEntity.ok("Order placed successfully");
}

//for(int id : ids) {
//	System.out.println(id);
//	Product product = productService.findProductById(id).get();
//	int orderedQuantity = orderItem.getQuantity();
//	if(product.getQuantity()>orderedQuantity) {
//	int remaningQuantity = product.getQuantity()-orderedQuantity;
//	product.setQuantity(remaningQuantity);
//	}
//	orderItem.setProduct(product);
//	productService.addProduct(product);
//}
//orderItem.setCustomer(customer);
//orderProductService.addOrderProduct(orderItem);
//	System.out.println("done");
//	return new ResponseEntity<String>("Completed " , HttpStatus.ACCEPTED);
	

@GetMapping("api-order/getAllOrderItems")
public ResponseEntity<List<OrderItem>> getAllOrderProducts() {
	try {
		return new ResponseEntity<List<OrderItem>>(orderItemService.getAllOrderProduct(), HttpStatus.OK);
	} catch (Exception e) {
		if(e!=null)
			throw new SellerNotFoundException();
	}
	return new ResponseEntity<List<OrderItem>>(orderItemService.getAllOrderProduct(), HttpStatus.OK);
}
}
