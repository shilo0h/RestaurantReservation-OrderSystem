package com.Klaos.Restaurant.Reservation.Ordering.System.service;

import com.Klaos.Restaurant.Reservation.Ordering.System.dto.OrderItemsDTO;
import com.Klaos.Restaurant.Reservation.Ordering.System.entitys.MenuItems;
import com.Klaos.Restaurant.Reservation.Ordering.System.entitys.OrderItems;
import com.Klaos.Restaurant.Reservation.Ordering.System.mapper.OrderItemsMapping;
import com.Klaos.Restaurant.Reservation.Ordering.System.repository.MenuItemsRepository;
import com.Klaos.Restaurant.Reservation.Ordering.System.repository.OrderItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemsService {
    @Autowired
    OrderItemsRepository orderItemsRepository;
    @Autowired
    OrderItemsMapping orderItemsMapping;
    @Autowired
    MenuItemsRepository menuItemsRepository;

    public List<OrderItemsDTO>getAll(){
        List<OrderItems>orderItems=orderItemsRepository.findAll();
        return orderItemsMapping.toListOrderItemsDTO(orderItems);
    }
    public OrderItemsDTO getById(Long id){
        OrderItems orderItems=orderItemsRepository.findById(id).orElseThrow(()->new RuntimeException("Not found"));
        return orderItemsMapping.toOderItemsDTO(orderItems);
    }
    public OrderItemsDTO addOrderItem(OrderItemsDTO orderItemsDTO){
        OrderItems orderItems=orderItemsMapping.toOrderItems(orderItemsDTO);
        orderItems.setQuantity(orderItemsDTO.getQuantity());
        orderItems.setPriceAtTheTime(orderItemsDTO.getPriceAtTheTime());
        if (orderItemsDTO.getMenuItemId()!=null){
            MenuItems menuItems=menuItemsRepository.findById(orderItemsDTO.getMenuItemId()).orElseThrow(()->new RuntimeException("Not found"));
            orderItems.setMenuItems(menuItems);
        }
        orderItemsRepository.save(orderItems);
        return orderItemsMapping.toOderItemsDTO(orderItems);
    }
    public OrderItemsDTO update(Long id,OrderItemsDTO orderItemsDTO){
        OrderItems orderItems=orderItemsRepository.findById(id).orElseThrow(()->new RuntimeException("Not found"));
        orderItems.setQuantity(orderItemsDTO.getQuantity());
        orderItems.setPriceAtTheTime(orderItemsDTO.getPriceAtTheTime());
        if (orderItemsDTO.getMenuItemId()!=null){
            MenuItems menuItems=menuItemsRepository.findById(orderItemsDTO.getMenuItemId()).orElseThrow(()->new RuntimeException("Not found"));
            orderItems.setMenuItems(menuItems);
        }
        orderItemsRepository.save(orderItems);
        return orderItemsMapping.toOderItemsDTO(orderItems);
    }
    public void deleteOrderItem(Long id){
        OrderItems orderItems=orderItemsRepository.findById(id).orElseThrow(()->new RuntimeException("Not found"));
        orderItemsRepository.delete(orderItems);
        System.out.println("Deleted OrderItem");
    }
}
