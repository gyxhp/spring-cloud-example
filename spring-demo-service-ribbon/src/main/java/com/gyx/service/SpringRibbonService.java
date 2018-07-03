package com.gyx.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by hp on 2018/7/2.
 */
@Service
public class SpringRibbonService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @HystrixCommand(fallbackMethod = "portFallBack")
    public String port(){
        this.loadBalancerClient.choose("spring-demo-service");//随机访问策略
        return restTemplate.getForObject("http://SPRING-DEMO-SERVICE/port",String.class);
    }

    public String portFallBack(){
        return "I'm sorry ribbon, it's error!";
    }

}
