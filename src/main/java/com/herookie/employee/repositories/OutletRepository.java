package com.herookie.employee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.herookie.employee.entities.Outlet;

public interface OutletRepository extends JpaRepository<Outlet, Long> {
}
