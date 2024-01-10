package com.herookie.employee.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.herookie.employee.entities.Outlet;
import com.herookie.employee.repositories.OutletRepository;
import com.herookie.employee.services.IOutletService;

@Service
public class OutletServiceImpl implements IOutletService {

    @Autowired
    private OutletRepository outletRepository;

    @Override
    public Outlet findById(long outletId) {
        return outletRepository.findById(outletId).orElse(null);
    }

    @Override
    public List<Outlet> findAll() {
        return outletRepository.findAll();
    }

    @Override
    public Outlet save(Outlet outlet) {
        return outletRepository.save(outlet);
    }

    @Override
    public void deleteOutlet(long outletId) {
        outletRepository.deleteById(outletId);
    }
}
