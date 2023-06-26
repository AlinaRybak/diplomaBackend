package com.example.diploma.controller;
import com.example.diploma.model.Order;
import com.example.diploma.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        Order createdOrder = orderService.createOrder(order);
        if (createdOrder != null) {
            return ResponseEntity.ok("Order placed successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error placing order");
        }
    }
}


