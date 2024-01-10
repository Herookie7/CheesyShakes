package com.herookie.employee.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.herookie.employee.entities.Outlet;
import com.herookie.employee.services.IOutletService;

@RestController
@RequestMapping("/outlets")
public class OutletController {

    @Autowired
    private IOutletService outletService;

    @GetMapping
    public ResponseEntity<List<Outlet>> getAllOutlets() {
        return new ResponseEntity<>(outletService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Outlet> getOutletById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(outletService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Outlet> createOutlet(@RequestBody Outlet outlet) {
        return new ResponseEntity<>(outletService.save(outlet), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Outlet> updateOutlet(@PathVariable("id") Long id, @RequestBody Outlet outlet) {
        outlet.setOutletId(id);
        return new ResponseEntity<>(outletService.save(outlet), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOutlet(@PathVariable("id") Long id) {
        outletService.deleteOutlet(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
