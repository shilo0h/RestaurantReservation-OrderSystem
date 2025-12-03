package com.Klaos.Restaurant.Reservation.Ordering.System.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TableDTO {
    private Long id;
    private Integer tableNumber;
    private Integer seatCount;

}
