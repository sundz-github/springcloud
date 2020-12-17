package com.sundz;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@Log4j2
@EnableEurekaServer
public class SpringcloudApplicationEurekaServer {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudApplicationEurekaServer.class, args);
        log.info("<-----SpringcloudApplicationEurekaServer is starting----->");
    }

}
