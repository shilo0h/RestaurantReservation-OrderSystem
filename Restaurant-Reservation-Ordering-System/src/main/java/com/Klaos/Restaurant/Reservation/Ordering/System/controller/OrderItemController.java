package com.Klaos.Restaurant.Reservation.Ordering.System.controller;

import com.Klaos.Restaurant.Reservation.Ordering.System.dto.OrderItemsDTO;
import com.Klaos.Restaurant.Reservation.Ordering.System.entitys.OrderItems;
import com.Klaos.Restaurant.Reservation.Ordering.System.service.OrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderItem")
public class OrderItemController {
    @Autowired
    OrderItemsService orderItemsService;
    @GetMapping
    public List<OrderItemsDTO>getAll(){
        return orderItemsService.getAll();
    }
    @GetMapping("/{id}")
    public OrderItemsDTO getById(@PathVariable Long id){
        return orderItemsService.getById(id);
    }
    @PostMapping
    public OrderItemsDTO add(@RequestBody OrderItemsDTO orderItemsDTO){
        return orderItemsService.addOrderItem(orderItemsDTO);
    }
    @PutMapping("/{id}")
    public OrderItemsDTO update(@PathVariable Long id,@RequestBody OrderItemsDTO orderItemsDTO){
        return orderItemsService.update(id,orderItemsDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteOrderItem(@PathVariable Long id){
        orderItemsService.deleteOrderItem(id);
    }
}
