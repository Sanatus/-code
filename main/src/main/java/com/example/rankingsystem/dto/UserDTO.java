// UserDTO.java
package com.example.rankingsystem.dto;

import java.util.Set;

public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String department;
    private int points;
    private Set<String> roles;
    
    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public int getPoints() { return points; }
    public void setPoints(int points) { this.points = points; }
    public Set<String> getRoles() { return roles; }
    public void setRoles(Set<String> roles) { this.roles = roles; }
}