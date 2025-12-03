package com.Klaos.Restaurant.Reservation.Ordering.System.controller;

import com.Klaos.Restaurant.Reservation.Ordering.System.dto.MenuItemsDTO;
import com.Klaos.Restaurant.Reservation.Ordering.System.service.MenuItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuItemsService menuItemsService;
    @GetMapping
    public List<MenuItemsDTO>getAll(){
        return menuItemsService.getAll();
    }
    @GetMapping("/{id}")
    public MenuItemsDTO getById(@PathVariable Long id){
        return menuItemsService.findById(id);
    }
    @PostMapping
    public MenuItemsDTO addMenu(@RequestBody MenuItemsDTO menuItemsDTO){
        return menuItemsService.addMenuItem(menuItemsDTO);
    }
    @PutMapping("/{id}")
    public MenuItemsDTO update(@PathVariable Long id,@RequestBody MenuItemsDTO menuItemsDTO){
        return menuItemsService.update(id,menuItemsDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteMenuItem(@PathVariable Long id){
        menuItemsService.delete(id);
    }
}
