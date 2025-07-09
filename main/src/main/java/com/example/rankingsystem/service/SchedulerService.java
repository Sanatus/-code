// SchedulerService.java
package com.example.rankingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulerService {
    
    @Autowired
    private RankingService rankingService;
    
    // 每10分钟更新一次排行榜
    @Scheduled(fixedRate = 10 * 60 * 1000)
    public void updateRankingsTask() {
        rankingService.updateRankings();
        System.out.println("排行榜已更新: " + System.currentTimeMillis());
    }
}