package com.Klaos.Restaurant.Reservation.Ordering.System.mapper;

import com.Klaos.Restaurant.Reservation.Ordering.System.dto.OrderDTO;
import com.Klaos.Restaurant.Reservation.Ordering.System.dto.OrderItemsDTO;
import com.Klaos.Restaurant.Reservation.Ordering.System.dto.TableDTO;
import com.Klaos.Restaurant.Reservation.Ordering.System.dto.UserDTO;
import com.Klaos.Restaurant.Reservation.Ordering.System.entitys.OrderItems;
import com.Klaos.Restaurant.Reservation.Ordering.System.entitys.Orders;
import com.Klaos.Restaurant.Reservation.Ordering.System.entitys.Tables;
import com.Klaos.Restaurant.Reservation.Ordering.System.entitys.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderItemsMapping {


    OrderItems toOrderItems(OrderItemsDTO orderItemsDTO);
    @Mapping(source = "menuItems.id", target = "menuItemId")
    OrderItemsDTO toOderItemsDTO(OrderItems orders);
    List<OrderItemsDTO> toListOrderItemsDTO(List<OrderItems>ordersList);
    List<OrderItems> toOrderItemsList(List<OrderItemsDTO>orderItemsDTOS);

}