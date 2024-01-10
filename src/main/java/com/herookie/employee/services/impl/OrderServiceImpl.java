package com.herookie.employee.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.herookie.employee.entities.Order;
import com.herookie.employee.entities.OrderStatus;
import com.herookie.employee.repositories.OrderRepository;
import com.herookie.employee.services.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order findById(long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(long orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public Order updateOrderStatus(long orderId, OrderStatus status) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setOrderStatus(status);
        return orderRepository.save(order);
    }
}
