// RankingRepository.java
package com.example.rankingsystem.repository;

import com.example.rankingsystem.model.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RankingRepository extends JpaRepository<Ranking, Long> {
    
    List<Ranking> findTop10ByTimestampOrderByPositionAsc(LocalDateTime timestamp);
    
    @Query("SELECT r FROM Ranking r WHERE r.timestamp = (SELECT MAX(r2.timestamp) FROM Ranking r2)")
    List<Ranking> findLatestRankings();
    
    Ranking findFirstByOrderByTimestampDesc();
}