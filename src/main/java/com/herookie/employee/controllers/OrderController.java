package com.herookie.employee.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.herookie.employee.entities.Order;
import com.herookie.employee.entities.OrderStatus;
import com.herookie.employee.services.IOrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(orderService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return new ResponseEntity<>(orderService.save(order), HttpStatus.CREATED);
    }

    // @GetMapping("/pending")
    // public ResponseEntity<List<Order>> getPendingOrders() {
    //     List<Order> pendingOrders = orderService.getOrdersByStatus(OrderStatus.PENDING);
    //     return new ResponseEntity<>(pendingOrders, HttpStatus.OK);
    // }

    // @GetMapping("/accepted")
    // public ResponseEntity<List<Order>> getAcceptedOrders() {
    //     List<Order> acceptedOrders = orderService.getOrdersByStatus(OrderStatus.ACCEPTED);
    //     return new ResponseEntity<>(acceptedOrders, HttpStatus.OK);
    // }

    // @GetMapping("/rejected")
    // public ResponseEntity<List<Order>> getRejectedOrders() {
    //     List<Order> rejectedOrders = orderService.getOrdersByStatus(OrderStatus.REJECTED);
    //     return new ResponseEntity<>(rejectedOrders, HttpStatus.OK);
    // }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable("id") Long id, @RequestBody Order order) {
        order.setOrderId(id);
        return new ResponseEntity<>(orderService.save(order), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}/accept")
    public ResponseEntity<Order> acceptOrder(@PathVariable("id") Long id) {
        return new ResponseEntity<>(orderService.updateOrderStatus(id, OrderStatus.ACCEPTED), HttpStatus.OK);
    }

    @PutMapping("/{id}/reject")
    public ResponseEntity<Order> rejectOrder(@PathVariable("id") Long id) {
        return new ResponseEntity<>(orderService.updateOrderStatus(id, OrderStatus.REJECTED), HttpStatus.OK);
    }
}
