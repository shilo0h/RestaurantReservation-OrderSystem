package com.Klaos.Restaurant.Reservation.Ordering.System.mapper;

import com.Klaos.Restaurant.Reservation.Ordering.System.dto.UserDTO;
import com.Klaos.Restaurant.Reservation.Ordering.System.entitys.Users;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapping {
     Users toUsers(UserDTO userDTO);
     UserDTO toUserDTO(Users users);
     List<UserDTO> toListUserDTO(List<Users>usersList);
}
