package com.Klaos.Restaurant.Reservation.Ordering.System.entitys;

import com.Klaos.Restaurant.Reservation.Ordering.System.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private Role role;
    @OneToMany(mappedBy = "users",cascade=CascadeType.ALL,orphanRemoval = true)
    private List<Reservations> reservations;

    @OneToMany(mappedBy = "users",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Orders> orders;
}
