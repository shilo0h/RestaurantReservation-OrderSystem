package com.Klaos.Restaurant.Reservation.Ordering.System.dto;

import com.Klaos.Restaurant.Reservation.Ordering.System.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private Role role;
}
