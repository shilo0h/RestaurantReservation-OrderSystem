package com.Klaos.Restaurant.Reservation.Ordering.System.service;

import com.Klaos.Restaurant.Reservation.Ordering.System.dto.OrderDTO;
import com.Klaos.Restaurant.Reservation.Ordering.System.dto.OrderItemsDTO;
import com.Klaos.Restaurant.Reservation.Ordering.System.entitys.*;
import com.Klaos.Restaurant.Reservation.Ordering.System.mapper.OrderItemsMapping;
import com.Klaos.Restaurant.Reservation.Ordering.System.mapper.OrderMapping;
import com.Klaos.Restaurant.Reservation.Ordering.System.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderMapping orderMapping;
    @Autowired
    TablesRepository tablesRepository;
    @Autowired
    OrderItemsRepository orderItemsRepository;
    @Autowired
    UserRepository userRepository;

    public List<OrderDTO> getAllOrders() {
        List<Orders> orders = orderRepository.findAll();
        return orderMapping.toOrderListDTO(orders);
    }

    public OrderDTO getById(Long id) {
        Orders orders = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        return orderMapping.toOrderDTO(orders);
    }


    public OrderDTO addOrder(OrderDTO orderDTO) {
        Orders orders = orderMapping.toOrders(orderDTO);
        orders.setOrderTime(orderDTO.getOrderTime());
        if (orderDTO.getUserId() != null) {
            Users users = userRepository.findById(orderDTO.getUserId()).orElseThrow(() -> new RuntimeException("Not found"));
            orders.setUsers(users);
        }
        if (orderDTO.getTableId() != null) {
            Tables tables = tablesRepository.findById(orderDTO.getTableId()).orElseThrow(() -> new RuntimeException("Not found"));
            orders.setTables(tables);
        }
        if (orderDTO.getOrderItemsDTO() != null) {
            List<OrderItems> existingItems = new ArrayList<>(); //list nje interface arrraylist esht nje abstract class interface esht nje kontrat per kalsat e tjera qe do e implementojm te ndjekin  je llogjike sepse ne intetrface vendosedn metoda pa llogjike brenda ndersa abstract klas mund te ket metoa me body dhe pa body ndryshim tjeter shum klasa mund te bejn shum implementime te interfce ,abstract class nuk mund ta inicializish
            for (OrderItemsDTO itemDTO : orderDTO.getOrderItemsDTO()) {       //this puts for every orderItem an Order
                OrderItems item = orderItemsRepository.findById(itemDTO.getId()).orElseThrow(() -> new RuntimeException("Not found"));
                item.setOrders(orders);
                existingItems.add(item);
            }
            orders.setOrderItems(existingItems);
        }
        Orders saveOrder = orderRepository.save(orders);

        return orderMapping.toOrderDTO(saveOrder);
    }

    public OrderDTO updateOrder(Long id, OrderDTO orderDTO) {
        Orders orders = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        orders.setOrderTime(orderDTO.getOrderTime());
        if (orderDTO.getUserId() != null) {
            Users users = userRepository.findById(orderDTO.getUserId()).orElseThrow(() -> new RuntimeException("Not found"));
            orders.setUsers(users);
        }
        if (orderDTO.getTableId() != null) {
            Tables tables = tablesRepository.findById(orderDTO.getTableId()).orElseThrow(() -> new RuntimeException("Not fund"));
            orders.setTables(tables);
        }
        if (orderDTO.getOrderItemsDTO() != null) {
            List<OrderItems> orderItems = new ArrayList<>();
            for (OrderItemsDTO itemsDTO : orderDTO.getOrderItemsDTO()) {
                OrderItems item = orderItemsRepository.findById(orderDTO.getId()).orElseThrow(() -> new RuntimeException("Not found"));
                item.setOrders(orders);
                orderItems.add(item);
            }
            orders.setOrderItems(orderItems);
        }
        Orders saveOrder = orderRepository.save(orders);
        return orderMapping.toOrderDTO(saveOrder);
    }

    public void deleteOrder(Long id){
        Orders orders=orderRepository.findById(id).orElseThrow(()->new RuntimeException("Not found"));
        orderRepository.delete(orders);
        System.out.println("Deleted Order");
    }
}
