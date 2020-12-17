package com.sundz;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@Log4j2
@EnableDiscoveryClient
public class SpringcloudApplicationScoreCard {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudApplicationScoreCard.class, args);
        log.info("<-----SpringcloudApplicationScoreCard is starting----->");
    }

}
