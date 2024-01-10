package com.herookie.employee.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.herookie.employee.entities.OfferCreation;
import com.herookie.employee.services.IOfferCreationService;

@RestController
@RequestMapping("/offer-creations")
public class OfferCreationController {

    @Autowired
    private IOfferCreationService offerCreationService;

    @GetMapping
    public ResponseEntity<List<OfferCreation>> getAllOfferCreations() {
        return new ResponseEntity<>(offerCreationService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfferCreation> getOfferCreationById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(offerCreationService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OfferCreation> createOfferCreation(@RequestBody OfferCreation offerCreation) {
        return new ResponseEntity<>(offerCreationService.save(offerCreation), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OfferCreation> updateOfferCreation(@PathVariable("id") Long id, @RequestBody OfferCreation offerCreation) {
        offerCreation.setOfferId(id);
        return new ResponseEntity<>(offerCreationService.save(offerCreation), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOfferCreation(@PathVariable("id") Long id) {
        offerCreationService.deleteOffer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
