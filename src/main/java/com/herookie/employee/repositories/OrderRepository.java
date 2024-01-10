package com.herookie.employee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.herookie.employee.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
