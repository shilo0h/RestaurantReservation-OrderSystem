package com.Klaos.Restaurant.Reservation.Ordering.System.mapper;

import com.Klaos.Restaurant.Reservation.Ordering.System.dto.MenuItemsDTO;
import com.Klaos.Restaurant.Reservation.Ordering.System.entitys.MenuItems;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MenuItemsMapping {
    MenuItems toMenuItems(MenuItemsDTO menuItemsDTO);
    MenuItemsDTO toMenuItemsDTO(MenuItems menuItems);
    List<MenuItemsDTO> toListMenuItemsDTO(List<MenuItems>menuItemsList);
}