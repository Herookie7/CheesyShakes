package com.herookie.employee.services;

import java.util.List;
import com.herookie.employee.entities.Outlet;
import com.herookie.employee.exceptions.EntityNotFoundException;
import com.herookie.employee.exceptions.ErrorProcessingException;
import com.herookie.employee.exceptions.UnsavedEntityException;

public interface IOutletService {
    Outlet findById(long outletId) throws ErrorProcessingException, EntityNotFoundException;
    List<Outlet> findAll() throws ErrorProcessingException;
    Outlet save(Outlet outlet) throws UnsavedEntityException;
    void deleteOutlet(long outletId) throws EntityNotFoundException;
}
