package com.Klaos.Restaurant.Reservation.Ordering.System.mapper;

import com.Klaos.Restaurant.Reservation.Ordering.System.dto.TableDTO;
import com.Klaos.Restaurant.Reservation.Ordering.System.dto.UserDTO;
import com.Klaos.Restaurant.Reservation.Ordering.System.entitys.Tables;
import com.Klaos.Restaurant.Reservation.Ordering.System.entitys.Users;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TableMapping {
    Tables toTable(TableDTO tableDTO);
    TableDTO toTablesDTO(Tables tables);
    List<TableDTO> toListTableDTO(List<Tables>tablesList);
}