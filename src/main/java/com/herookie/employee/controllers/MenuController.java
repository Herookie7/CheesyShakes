package com.herookie.employee.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.herookie.employee.entities.Menu;
import com.herookie.employee.services.IMenuService;

@RestController
@RequestMapping("/menus")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @GetMapping
    public ResponseEntity<List<Menu>> getAllMenus() {
        return new ResponseEntity<>(menuService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menu> getMenuById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(menuService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Menu> createMenu(@RequestBody Menu menu) {
        return new ResponseEntity<>(menuService.save(menu), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Menu> updateMenu(@PathVariable("id") Long id, @RequestBody Menu menu) {
        menu.setMenuId(id);
        return new ResponseEntity<>(menuService.save(menu), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable("id") Long id) {
        menuService.deleteMenu(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
