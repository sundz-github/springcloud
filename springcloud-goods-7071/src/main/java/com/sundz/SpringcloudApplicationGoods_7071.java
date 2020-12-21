package com.sundz;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@Log4j2
@EnableDiscoveryClient
@EnableCircuitBreaker    // 开启熔断
public class SpringcloudApplicationGoods_7071 {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudApplicationGoods_7071.class, args);
        log.info("<-----SpringcloudApplicationGoods_7071 is starting----->");
    }

}
