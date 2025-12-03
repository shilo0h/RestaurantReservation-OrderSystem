package com.Klaos.Restaurant.Reservation.Ordering.System.repository;

import com.Klaos.Restaurant.Reservation.Ordering.System.entitys.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Long> {
}
