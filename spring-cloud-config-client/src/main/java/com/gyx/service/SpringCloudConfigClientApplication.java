package com.gyx.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hp on 2018/7/10.
 */

@SpringBootApplication
@RestController
public class SpringCloudConfigClientApplication {
    public static void main(String[] args){
        SpringApplication.run(SpringCloudConfigClientApplication.class,args);
    }

    @Value("${hello}")
    private String hello;

    @RequestMapping(value = {"hello"})
    public String hello(){
        return hello;
    }
}
