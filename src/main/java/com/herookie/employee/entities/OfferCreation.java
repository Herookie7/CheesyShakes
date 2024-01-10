package com.herookie.employee.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "offer_creations")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfferCreation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long offerId;

    private String item;
    private Double amount;
}
