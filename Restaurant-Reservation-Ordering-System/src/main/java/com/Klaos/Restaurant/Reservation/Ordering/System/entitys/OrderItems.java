package com.Klaos.Restaurant.Reservation.Ordering.System.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_items")
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    private Double priceAtTheTime;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "menu_items_id")
    private MenuItems menuItems;


}
