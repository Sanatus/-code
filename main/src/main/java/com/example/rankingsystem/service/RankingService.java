// RankingService.java
package com.example.rankingsystem.service;

import com.example.rankingsystem.model.Ranking;
import com.example.rankingsystem.model.User;
import com.example.rankingsystem.repository.RankingRepository;
import com.example.rankingsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RankingService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RankingRepository rankingRepository;
    
    @Transactional
    public void updateRankings() {
        // 获取所有用户并排序
        List<User> users = userRepository.findAll();
        List<User> sortedUsers = users.stream()
            .sorted(Comparator.comparingInt(User::getPoints).reversed())
            .collect(Collectors.toList());
        
        // 创建新的排行榜记录
        LocalDateTime now = LocalDateTime.now();
        int position = 1;
        
        for (User user : sortedUsers) {
            Ranking ranking = new Ranking();
            ranking.setUser(user);
            ranking.setPosition(position++);
            ranking.setPoints(user.getPoints());
            ranking.setTimestamp(now);
            rankingRepository.save(ranking);
        }
    }
    
    public List<Ranking> getLatestRankings() {
        return rankingRepository.findLatestRankings();
    }
    
    public List<Ranking> getTop10Rankings() {
        LocalDateTime latestTimestamp = rankingRepository.findFirstByOrderByTimestampDesc().getTimestamp();
        return rankingRepository.findTop10ByTimestampOrderByPositionAsc(latestTimestamp);
    }
}