package com.ribbon;

import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p> Ribbon负载均衡配置 </p>
 * ps: @Configuration注解必须要
 *
 * @author Sundz
 * @date 2020/12/18 17:32
 */
@Configuration
public class RibbonConfig {

    /**
     * @field 负载均衡算法  默认为轮询算法
     */
    @Bean
    public IRule iRule() {
        // 请求最少的算法
        return new BestAvailableRule();
    }
}
