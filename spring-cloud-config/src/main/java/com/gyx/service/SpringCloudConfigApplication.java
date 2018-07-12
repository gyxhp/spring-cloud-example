package com.gyx.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by gyxhp on 2018/7/9.
 */
@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigApplication {
    public static  void main(String[] args){
        SpringApplication.run(SpringCloudConfigApplication.class,args);
    }
}
