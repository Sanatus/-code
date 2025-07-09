// AdminController.java
package com.example.rankingsystem.controller;

import com.example.rankingsystem.dto.UserDTO;
import com.example.rankingsystem.model.User;
import com.example.rankingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        List<User> users = userService.getAllUsers();
        List<UserDTO> response = users.stream().map(user -> {
            UserDTO dto = new UserDTO();
            dto.setId(user.getId());
            dto.setUsername(user.getUsername());
            dto.setName(user.getName());
            dto.setDepartment(user.getDepartment());
            dto.setPoints(user.getPoints());
            dto.setRoles(user.getRoles());
            return dto;
        }).collect(Collectors.toList());
        
        return ResponseEntity.ok(response);
    }
    
    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        User user = userService.getUserById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        
        user.setName(userDTO.getName());
        user.setDepartment(userDTO.getDepartment());
        user.setPoints(userDTO.getPoints());
        
        User updatedUser = userService.updateUser(user);
        
        UserDTO response = new UserDTO();
        response.setId(updatedUser.getId());
        response.setUsername(updatedUser.getUsername());
        response.setName(updatedUser.getName());
        response.setDepartment(updatedUser.getDepartment());
        response.setPoints(updatedUser.getPoints());
        response.setRoles(updatedUser.getRoles());
        
        return ResponseEntity.ok(response);
    }
    
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().body("用户已删除");
    }
}