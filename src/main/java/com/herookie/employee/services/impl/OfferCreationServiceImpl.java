package com.herookie.employee.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.herookie.employee.entities.OfferCreation;
import com.herookie.employee.repositories.OfferCreationRepository;
import com.herookie.employee.services.IOfferCreationService;

@Service
public class OfferCreationServiceImpl implements IOfferCreationService {

    @Autowired
    private OfferCreationRepository offerCreationRepository;

    @Override
    public OfferCreation findById(long offerId) {
        return offerCreationRepository.findById(offerId).orElse(null);
    }

    @Override
    public List<OfferCreation> findAll() {
        return offerCreationRepository.findAll();
    }

    @Override
    public OfferCreation save(OfferCreation offerCreation) {
        return offerCreationRepository.save(offerCreation);
    }

    @Override
    public void deleteOffer(long offerId) {
        offerCreationRepository.deleteById(offerId);
    }
}
