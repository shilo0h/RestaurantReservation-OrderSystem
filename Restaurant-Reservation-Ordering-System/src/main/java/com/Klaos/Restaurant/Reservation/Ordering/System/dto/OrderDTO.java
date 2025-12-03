package com.Klaos.Restaurant.Reservation.Ordering.System.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private LocalDateTime orderTime;
    private Long userId;
    private Long tableId;
    private List<OrderItemsDTO> orderItemsDTO;
}
