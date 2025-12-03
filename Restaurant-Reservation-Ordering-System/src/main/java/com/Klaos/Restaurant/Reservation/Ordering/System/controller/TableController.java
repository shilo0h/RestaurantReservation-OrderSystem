package com.Klaos.Restaurant.Reservation.Ordering.System.controller;

import com.Klaos.Restaurant.Reservation.Ordering.System.dto.TableDTO;
import com.Klaos.Restaurant.Reservation.Ordering.System.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/table")
public class TableController {
    @Autowired
    private TableService tableService;
    @GetMapping
    public List<TableDTO> getAll(){
        return tableService.getAllTable();
    }
    @GetMapping("/{id}")
    public TableDTO getById(@PathVariable Long id){
        return tableService.findById(id);
    }
    @PostMapping
    public TableDTO addTable(@RequestBody TableDTO tableDTO){
        return tableService.addTable(tableDTO);
    }
    @PutMapping("/{id}")
    public TableDTO updateTable(@PathVariable Long id, @RequestBody TableDTO tableDTO){
        return tableService.updateTable(id,tableDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteTable(@PathVariable Long id){
        tableService.deleteTable(id);
    }
}
