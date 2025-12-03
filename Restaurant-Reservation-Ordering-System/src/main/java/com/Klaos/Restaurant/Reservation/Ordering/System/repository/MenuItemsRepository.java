package com.Klaos.Restaurant.Reservation.Ordering.System.repository;

import com.Klaos.Restaurant.Reservation.Ordering.System.entitys.MenuItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemsRepository extends JpaRepository <MenuItems,Long>{
}
