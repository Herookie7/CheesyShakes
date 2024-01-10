package com.herookie.employee.services;

import java.util.List;
import com.herookie.employee.entities.Order;
import com.herookie.employee.entities.OrderStatus;
import com.herookie.employee.exceptions.EntityNotFoundException;
import com.herookie.employee.exceptions.ErrorProcessingException;
import com.herookie.employee.exceptions.UnsavedEntityException;

public interface IOrderService {
    Order findById(long orderId) throws ErrorProcessingException, EntityNotFoundException;
    List<Order> findAll() throws ErrorProcessingException;
    Order save(Order order) throws UnsavedEntityException;
    void deleteOrder(long orderId) throws EntityNotFoundException;
    Order updateOrderStatus(long orderId, OrderStatus status);
    
}
