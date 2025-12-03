package com.Klaos.Restaurant.Reservation.Ordering.System.service;

import com.Klaos.Restaurant.Reservation.Ordering.System.dto.TableDTO;
import com.Klaos.Restaurant.Reservation.Ordering.System.entitys.Tables;
import com.Klaos.Restaurant.Reservation.Ordering.System.mapper.TableMapping;
import com.Klaos.Restaurant.Reservation.Ordering.System.repository.TablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {
    @Autowired
    TablesRepository tablesRepository;
    @Autowired
    TableMapping tableMapping;

    public List<TableDTO> getAllTable(){
        List<Tables>tables=tablesRepository.findAll();
        return tableMapping.toListTableDTO(tables);
    }
    public TableDTO findById(Long id){
        Tables tables=tablesRepository.findById(id).orElseThrow(()->new RuntimeException("Table not found"));
        return tableMapping.toTablesDTO(tables);
    }

    public TableDTO addTable(TableDTO tableDTO){
        Tables tables=tableMapping.toTable(tableDTO);
        tables.setTableNumber(tableDTO.getTableNumber());
        tables.setSeatCount(tableDTO.getSeatCount());
        tablesRepository.save(tables);
        return tableMapping.toTablesDTO(tables);
    }
    public TableDTO updateTable(Long id,TableDTO tableDTO){
        Tables tables=tablesRepository.findById(id).orElseThrow(()->new RuntimeException("Table not found"));
        tables.setTableNumber(tableDTO.getTableNumber());
        tables.setSeatCount(tableDTO.getSeatCount());
        tablesRepository.save(tables);
        return tableMapping.toTablesDTO(tables);
    }

    public void deleteTable(Long id){
        Tables tables=tablesRepository.findById(id).orElseThrow(()->new RuntimeException("Table not found"));
        tablesRepository.delete(tables);
        System.out.println("Deleted table");
    }
}
