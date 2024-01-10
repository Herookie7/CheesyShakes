package com.herookie.employee.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.herookie.employee.entities.Menu;
import com.herookie.employee.repositories.MenuRepository;
import com.herookie.employee.services.IMenuService;

@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public Menu findById(long menuId) {
        return menuRepository.findById(menuId).orElse(null);
    }

    @Override
    public List<Menu> findAll() {
        return menuRepository.findAll();
    }

    @Override
    public Menu save(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public void deleteMenu(long menuId) {
        menuRepository.deleteById(menuId);
    }
}
