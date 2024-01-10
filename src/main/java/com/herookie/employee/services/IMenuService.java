package com.herookie.employee.services;

import java.util.List;
import com.herookie.employee.entities.Menu;
import com.herookie.employee.exceptions.EntityNotFoundException;
import com.herookie.employee.exceptions.ErrorProcessingException;
import com.herookie.employee.exceptions.UnsavedEntityException;

public interface IMenuService {
    Menu findById(long menuId) throws ErrorProcessingException, EntityNotFoundException;
    List<Menu> findAll() throws ErrorProcessingException;
    Menu save(Menu menu) throws UnsavedEntityException;
    void deleteMenu(long menuId) throws EntityNotFoundException;
}
