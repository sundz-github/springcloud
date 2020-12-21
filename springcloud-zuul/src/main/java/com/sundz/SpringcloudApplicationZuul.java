package com.sundz;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@Log4j2
@EnableDiscoveryClient
@EnableZuulProxy  // 开启Zuul路由代理
public class SpringcloudApplicationZuul {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudApplicationZuul.class, args);
        log.info("<-----SpringcloudApplicationZuul is starting----->");
    }

}
