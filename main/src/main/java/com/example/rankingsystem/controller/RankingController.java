// RankingController.java
package com.example.rankingsystem.controller;

import com.example.rankingsystem.dto.RankingEntry;
import com.example.rankingsystem.model.Ranking;
import com.example.rankingsystem.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ranking")
public class RankingController {
    
    @Autowired
    private RankingService rankingService;
    
    @GetMapping("/top")
    public ResponseEntity<?> getTopRankings() {
        List<Ranking> rankings = rankingService.getTop10Rankings();
        
        List<RankingEntry> response = rankings.stream().map(ranking -> {
            RankingEntry entry = new RankingEntry();
            entry.setPosition(ranking.getPosition());
            entry.setUserId(ranking.getUser().getId());
            entry.setUsername(ranking.getUser().getUsername());
            entry.setName(ranking.getUser().getName());
            entry.setDepartment(ranking.getUser().getDepartment());
            entry.setPoints(ranking.getPoints());
            return entry;
        }).collect(Collectors.toList());
        
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/latest")
    public ResponseEntity<?> getLatestRankings() {
        List<Ranking> rankings = rankingService.getLatestRankings();
        
        List<RankingEntry> response = rankings.stream().map(ranking -> {
            RankingEntry entry = new RankingEntry();
            entry.setPosition(ranking.getPosition());
            entry.setUserId(ranking.getUser().getId());
            entry.setUsername(ranking.getUser().getUsername());
            entry.setName(ranking.getUser().getName());
            entry.setDepartment(ranking.getUser().getDepartment());
            entry.setPoints(ranking.getPoints());
            return entry;
        }).collect(Collectors.toList());
        
        return ResponseEntity.ok(response);
    }
}