package com.Klaos.Restaurant.Reservation.Ordering.System.controller;

import com.Klaos.Restaurant.Reservation.Ordering.System.dto.OrderDTO;
import com.Klaos.Restaurant.Reservation.Ordering.System.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrdersService ordersService;

    @GetMapping
    public List<OrderDTO> getAll(){
        return ordersService.getAllOrders();
    }
    @GetMapping("/{id}")
    public OrderDTO getById(@PathVariable Long id){
        return ordersService.getById(id);
    }
    @PostMapping
    public OrderDTO addOrder(@RequestBody OrderDTO orderDTO){
       return ordersService.addOrder(orderDTO);
    }
    @PutMapping("/{id}")
    public OrderDTO updateOrder(@PathVariable Long id,@RequestBody OrderDTO orderDTO){
        return ordersService.updateOrder(id,orderDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteOder(@PathVariable Long id){
        ordersService.deleteOrder(id);
    }
}
