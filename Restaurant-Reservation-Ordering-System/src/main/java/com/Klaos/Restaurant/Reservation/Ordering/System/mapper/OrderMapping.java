package com.Klaos.Restaurant.Reservation.Ordering.System.mapper;

import com.Klaos.Restaurant.Reservation.Ordering.System.dto.OrderDTO;
import com.Klaos.Restaurant.Reservation.Ordering.System.dto.UserDTO;
import com.Klaos.Restaurant.Reservation.Ordering.System.entitys.Orders;
import com.Klaos.Restaurant.Reservation.Ordering.System.entitys.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapping {
    Orders toOrders(OrderDTO orderDTO);
    @Mapping(source = "users.id",target = "userId")
    @Mapping(source = "tables.id",target = "tableId")
    @Mapping(source = "orderItems",target = "orderItemsDTO")
    OrderDTO toOrderDTO(Orders orders);
    List<OrderDTO> toOrderListDTO(List<Orders>ordersList);
    List<Orders>toOrderList(List<OrderDTO>orderDTOList);
}