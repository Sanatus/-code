// RankingSystemApplication.java
package com.example.rankingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RankingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(RankingSystemApplication.class, args);
    }
}