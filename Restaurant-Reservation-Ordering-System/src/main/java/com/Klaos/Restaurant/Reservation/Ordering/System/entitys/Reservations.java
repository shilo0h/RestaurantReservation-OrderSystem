package com.Klaos.Restaurant.Reservation.Ordering.System.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "reservations")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime reservationTime;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;
    @ManyToOne
    @JoinColumn(name = "table_id")
    private Tables tables;

}
