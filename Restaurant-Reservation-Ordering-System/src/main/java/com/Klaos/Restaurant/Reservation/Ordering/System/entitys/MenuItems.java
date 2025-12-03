package com.Klaos.Restaurant.Reservation.Ordering.System.entitys;

import ch.qos.logback.core.model.INamedModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "menu_items")
public class MenuItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;

    @OneToMany(mappedBy = "menuItems",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<OrderItems>orderItems;

}
