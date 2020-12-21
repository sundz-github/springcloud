package com.sundz;

import com.ribbon.RibbonConfig;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@Log4j2
@EnableFeignClients // 开启器feign
@EnableCircuitBreaker  // 开启熔断
/**
 * @field RibbonConfig配置类不能被springboot扫描，否则该配置将会作为全局配置
 */
@RibbonClient(name = "SPRINGCLOUD-GOODS", configuration = RibbonConfig.class)
public class SpringcloudApplicationConsumer {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudApplicationConsumer.class, args);
        log.info("<-----SpringcloudApplicationConsumer is starting----->");
    }

}
