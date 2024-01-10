package com.herookie.employee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.herookie.employee.entities.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
