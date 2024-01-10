package com.herookie.employee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.herookie.employee.entities.OfferCreation;

public interface OfferCreationRepository extends JpaRepository<OfferCreation, Long> {
}
