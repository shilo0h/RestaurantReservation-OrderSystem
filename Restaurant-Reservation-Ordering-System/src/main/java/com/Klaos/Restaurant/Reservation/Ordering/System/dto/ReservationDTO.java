package com.Klaos.Restaurant.Reservation.Ordering.System.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservationDTO {
    private Long id;
    private LocalDateTime reservationTime;
    private Long userId;
    private Long tableId;

}
