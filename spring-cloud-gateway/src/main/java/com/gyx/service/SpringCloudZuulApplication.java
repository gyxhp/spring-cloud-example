package com.gyx.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by hp on 2018/7/11.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class SpringCloudZuulApplication {
    public static void main(String[] args){
        SpringApplication.run(SpringCloudZuulApplication.class,args);
    }
}
