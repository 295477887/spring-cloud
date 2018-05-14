package com.chen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author: ChenJie
 * @date 2018/5/14
 *
 * EnableHystrix 开启断路器
 * EnableHystrixDashboard 开启断路器监控仪表盘
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard
public class ServiceRibbonHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceRibbonHystrixApplication.class, args);
    }

    /**
     * 创建restTemplate，开启负载均衡功能
     * */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
