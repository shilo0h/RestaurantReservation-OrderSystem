package com.Klaos.Restaurant.Reservation.Ordering.System.mapper;

import com.Klaos.Restaurant.Reservation.Ordering.System.dto.ReservationDTO;
import com.Klaos.Restaurant.Reservation.Ordering.System.dto.UserDTO;
import com.Klaos.Restaurant.Reservation.Ordering.System.entitys.Reservations;
import com.Klaos.Restaurant.Reservation.Ordering.System.entitys.Users;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservationMapping {
    Reservations toReservation(ReservationDTO reservationDTO);
    ReservationDTO toReservationDTO(Reservations reservations);
    List<ReservationDTO> toListReservationDTO(List<Reservations>reservationsList);
}