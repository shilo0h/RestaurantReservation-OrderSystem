package com.Klaos.Restaurant.Reservation.Ordering.System.service;

import com.Klaos.Restaurant.Reservation.Ordering.System.dto.MenuItemsDTO;
import com.Klaos.Restaurant.Reservation.Ordering.System.entitys.MenuItems;
import com.Klaos.Restaurant.Reservation.Ordering.System.mapper.MenuItemsMapping;
import com.Klaos.Restaurant.Reservation.Ordering.System.repository.MenuItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemsService {
    @Autowired
    MenuItemsMapping menuItemsMapping;
    @Autowired
    MenuItemsRepository menuItemsRepository;

    public List<MenuItemsDTO> getAll(){
        List<MenuItems>menuItems=menuItemsRepository.findAll();
        return menuItemsMapping.toListMenuItemsDTO(menuItems);
    }
    public MenuItemsDTO findById(Long id){
        MenuItems menuItems=menuItemsRepository.findById(id).orElseThrow(()->new RuntimeException("Not found"));
        return menuItemsMapping.toMenuItemsDTO(menuItems);
    }
    public MenuItemsDTO addMenuItem(MenuItemsDTO menuItemsDTO){
        MenuItems menuItems=menuItemsMapping.toMenuItems(menuItemsDTO);
        menuItems.setName(menuItemsDTO.getName());
        menuItems.setPrice(menuItemsDTO.getPrice());
        menuItemsRepository.save(menuItems);
        return menuItemsMapping.toMenuItemsDTO(menuItems);
    }
    public MenuItemsDTO update(Long id,MenuItemsDTO menuItemsDTO){
        MenuItems menuItems=menuItemsRepository.findById(id).orElseThrow(()->new RuntimeException("Not found"));
        menuItems.setName(menuItemsDTO.getName());
        menuItems.setPrice(menuItemsDTO.getPrice());
        menuItemsRepository.save(menuItems);
        return menuItemsMapping.toMenuItemsDTO(menuItems);
    }
    public void delete(Long id){
        MenuItems menuItems=menuItemsRepository.findById(id).orElseThrow(()->new RuntimeException("Not found"));
        menuItemsRepository.delete(menuItems);
        System.out.println("Deleted menu item");
    }
}
