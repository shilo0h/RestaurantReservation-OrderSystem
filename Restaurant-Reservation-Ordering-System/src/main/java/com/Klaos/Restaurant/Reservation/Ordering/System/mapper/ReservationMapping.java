package com.Klaos.Restaurant.Reservation.Ordering.System.mapper;

import com.Klaos.Restaurant.Reservation.Ordering.System.dto.ReservationDTO;
import com.Klaos.Restaurant.Reservation.Ordering.System.dto.UserDTO;
import com.Klaos.Restaurant.Reservation.Ordering.System.entitys.Reservations;
import com.Klaos.Restaurant.Reservation.Ordering.System.entitys.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservationMapping {
    @Mapping(source = "userId",target = "users.id")
    @Mapping(source = "tableId",target = "tables.id")
    Reservations toReservation(ReservationDTO reservationDTO);
    @Mapping(source = "users.id", target = "userId")
    @Mapping(source = "tables.id", target = "tableId")
    ReservationDTO toReservationDTO(Reservations reservations);
    List<ReservationDTO> toListReservationDTO(List<Reservations>reservationsList);
}