package com.Klaos.Restaurant.Reservation.Ordering.System.service;

import com.Klaos.Restaurant.Reservation.Ordering.System.dto.UserDTO;
import com.Klaos.Restaurant.Reservation.Ordering.System.entitys.Users;
import com.Klaos.Restaurant.Reservation.Ordering.System.mapper.UserMapping;
import com.Klaos.Restaurant.Reservation.Ordering.System.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapping userMapping;

    public List<UserDTO> getAllUsers(){
        List<Users>users=userRepository.findAll();
        return userMapping.toListUserDTO(users);
    }

    public UserDTO getUserById(Long id){
        Users users=userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
        return userMapping.toUserDTO(users);
    }

    public UserDTO addUser(UserDTO userDTO){
        Users user=userMapping.toUsers(userDTO);
         user.setName(userDTO.getName());
         user.setPhone(userDTO.getPhone());
         user.setEmail(userDTO.getEmail());
         user.setRole(userDTO.getRole());
        userRepository.save(user);
        return userMapping.toUserDTO(user);
    }

    public UserDTO updateUser(Long id,UserDTO userDTO){
        Users users=userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
        users.setName(userDTO.getName());
        users.setPhone(userDTO.getPhone());
        users.setEmail(userDTO.getEmail());
        users.setRole(userDTO.getRole());
        userRepository.save(users);
        return userMapping.toUserDTO(users);

    }

    public void deleteUser(Long id){
        Users users=userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
        userRepository.delete(users);
        System.out.println("User deleted successfully");
    }
}
