package com.Klaos.Restaurant.Reservation.Ordering.System.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.batch.BatchTransactionManager;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime orderTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    Users users;

    @ManyToOne
    @JoinColumn(name = "table_id")
    Tables tables;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItems> orderItems;

}
