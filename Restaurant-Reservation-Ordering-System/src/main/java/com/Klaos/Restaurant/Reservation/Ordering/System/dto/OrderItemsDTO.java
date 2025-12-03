package com.Klaos.Restaurant.Reservation.Ordering.System.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemsDTO {
    private Long id;
    private Long menuItemId;
    private Integer quantity;
    private Double priceAtTheTime;
}
