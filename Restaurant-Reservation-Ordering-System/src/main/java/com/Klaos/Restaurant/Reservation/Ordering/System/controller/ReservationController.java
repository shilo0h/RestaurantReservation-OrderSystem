package com.Klaos.Restaurant.Reservation.Ordering.System.controller;

import com.Klaos.Restaurant.Reservation.Ordering.System.dto.ReservationDTO;
import com.Klaos.Restaurant.Reservation.Ordering.System.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    ReservationService reservationService;
    @GetMapping
    public List<ReservationDTO>getAll(){
        return reservationService.getAllReservations();
    }
    @GetMapping("/{id}")
    public ReservationDTO getById(@PathVariable Long id){
        return reservationService.getById(id);
    }
    @PostMapping
    public ReservationDTO addReservation(@RequestBody ReservationDTO reservationDTO){
        return reservationService.addReservation(reservationDTO);
    }
    @PutMapping("/{id}")
    public ReservationDTO update(@PathVariable Long id,@RequestBody ReservationDTO reservationDTO){
        return reservationService.updateReservation(id,reservationDTO);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        reservationService.deleteReservation(id);
    }
}
