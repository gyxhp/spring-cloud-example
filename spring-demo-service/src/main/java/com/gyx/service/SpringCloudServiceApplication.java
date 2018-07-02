package com.gyx.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hp on 2018/7/2.
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class SpringCloudServiceApplication {
    public static void main(String[] args){
        SpringApplication.run(SpringCloudServiceApplication.class,args);
    }
}
