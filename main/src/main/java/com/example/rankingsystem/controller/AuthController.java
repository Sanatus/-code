// AuthController.java
package com.example.rankingsystem.controller;

import com.example.rankingsystem.dto.LoginRequest;
import com.example.rankingsystem.dto.UserDTO;
import com.example.rankingsystem.model.User;
import com.example.rankingsystem.repository.UserRepository;
import com.example.rankingsystem.security.JwtUtils;
import com.example.rankingsystem.security.UserDetailsImpl;
import com.example.rankingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private JwtUtils jwtUtils;
    
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        
        Map<String, Object> response = new HashMap<>();
        response.put("token", jwt);
        response.put("id", userDetails.getId());
        response.put("username", userDetails.getUsername());
        response.put("name", userDetails.getName());
        response.put("roles", userDetails.getRoles());
        
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setName(userDTO.getName());
        user.setDepartment(userDTO.getDepartment());
        
        User registeredUser = userService.registerUser(user);
        
        Map<String, Object> response = new HashMap<>();
        response.put("message", "用户注册成功");
        response.put("userId", registeredUser.getId());
        
        return ResponseEntity.ok(response);
    }
}