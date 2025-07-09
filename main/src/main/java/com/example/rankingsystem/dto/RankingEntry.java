// RankingEntry.java
package com.example.rankingsystem.dto;

public class RankingEntry {
    private int position;
    private Long userId;
    private String username;
    private String name;
    private String department;
    private int points;
    
    // Getters and setters
    public int getPosition() { return position; }
    public void setPosition(int position) { this.position = position; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public int getPoints() { return points; }
    public void setPoints(int points) { this.points = points; }
}