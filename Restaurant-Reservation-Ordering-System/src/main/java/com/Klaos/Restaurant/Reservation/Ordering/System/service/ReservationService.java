package com.Klaos.Restaurant.Reservation.Ordering.System.service;

import com.Klaos.Restaurant.Reservation.Ordering.System.dto.ReservationDTO;
import com.Klaos.Restaurant.Reservation.Ordering.System.entitys.Reservations;
import com.Klaos.Restaurant.Reservation.Ordering.System.entitys.Tables;
import com.Klaos.Restaurant.Reservation.Ordering.System.entitys.Users;
import com.Klaos.Restaurant.Reservation.Ordering.System.mapper.ReservationMapping;
import com.Klaos.Restaurant.Reservation.Ordering.System.repository.ReservationRepository;
import com.Klaos.Restaurant.Reservation.Ordering.System.repository.TablesRepository;
import com.Klaos.Restaurant.Reservation.Ordering.System.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService {
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    ReservationMapping reservationMapping;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TablesRepository tablesRepository;

    public List<ReservationDTO> getAllReservations(){
        List<Reservations>reservations=reservationRepository.findAll();
        return reservationMapping.toListReservationDTO(reservations);
    }
    public ReservationDTO getById(Long id){
        Reservations reservations=reservationRepository.findById(id).orElseThrow(()->new RuntimeException("Not found"));
        return reservationMapping.toReservationDTO(reservations);
    }
    public ReservationDTO addReservation(ReservationDTO reservationDTO){
        Reservations reservations=reservationMapping.toReservation(reservationDTO);
        reservations.setReservationTime(reservationDTO.getReservationTime());
        if (reservationDTO.getUserId()!=null){
            Users users=userRepository.findById(reservationDTO.getUserId()).orElseThrow(()->new RuntimeException("Not found"));
            reservations.setUsers(users);
        }
        if (reservationDTO.getTableId()!=null){
            Tables tables=tablesRepository.findById(reservationDTO.getTableId()).orElseThrow(()->new RuntimeException("Not found"));
            reservations.setTables(tables);
        }
                reservationRepository.save(reservations);
            return reservationMapping.toReservationDTO(reservations);
    }

    public  ReservationDTO updateReservation(Long id,ReservationDTO reservationDTO){
        Reservations reservations=reservationRepository.findById(id).orElseThrow(()->new RuntimeException("Not found"));
        reservations.setReservationTime(reservationDTO.getReservationTime());
        if (reservationDTO.getUserId()!=null){
            Users users=userRepository.findById(reservationDTO.getUserId()).orElseThrow(()->new RuntimeException("Not found"));
            reservations.setUsers(users);
        }
        if (reservationDTO.getTableId()!=null){
            Tables tables=tablesRepository.findById(reservationDTO.getTableId()).orElseThrow(()->new RuntimeException("Not found"));
            reservations.setTables(tables);
        }
        reservationRepository.save(reservations);
        return reservationMapping.toReservationDTO(reservations);
    }

    public void deleteReservation(Long id){
        Reservations reservations=reservationRepository.findById(id).orElseThrow(()->new RuntimeException("Not found"));
        reservationRepository.delete(reservations);
        System.out.println("Deleted");
    }
}
