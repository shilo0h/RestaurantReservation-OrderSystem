package com.Klaos.Restaurant.Reservation.Ordering.System.controller;

import com.Klaos.Restaurant.Reservation.Ordering.System.dto.UserDTO;
import com.Klaos.Restaurant.Reservation.Ordering.System.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public List<UserDTO>getAll(){
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable Long id){
        return userService.getUserById(id);
    }
    @PostMapping()
    public UserDTO addUser(@RequestBody UserDTO userDTO){
        return userService.addUser(userDTO);
    }
    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable Long id,@RequestBody UserDTO userDTO){
        return userService.updateUser(id,userDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
