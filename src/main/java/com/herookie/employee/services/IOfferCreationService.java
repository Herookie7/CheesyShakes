package com.herookie.employee.services;

import java.util.List;
import com.herookie.employee.entities.OfferCreation;
import com.herookie.employee.exceptions.EntityNotFoundException;
import com.herookie.employee.exceptions.ErrorProcessingException;
import com.herookie.employee.exceptions.UnsavedEntityException;

public interface IOfferCreationService {
    OfferCreation findById(long offerId) throws ErrorProcessingException, EntityNotFoundException;
    List<OfferCreation> findAll() throws ErrorProcessingException;
    OfferCreation save(OfferCreation offerCreation) throws UnsavedEntityException;
    void deleteOffer(long offerId) throws EntityNotFoundException;
}
