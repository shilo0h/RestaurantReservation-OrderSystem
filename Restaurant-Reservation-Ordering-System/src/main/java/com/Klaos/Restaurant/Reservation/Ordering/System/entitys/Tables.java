package com.Klaos.Restaurant.Reservation.Ordering.System.entitys;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tables")
public class Tables {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer tableNumber;
    private Integer seatCount;
    @OneToMany(mappedBy = "tables",cascade = CascadeType.ALL,orphanRemoval = true)
    List<Reservations>reservations;
}
