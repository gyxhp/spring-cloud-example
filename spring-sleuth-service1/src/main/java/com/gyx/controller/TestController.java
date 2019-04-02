package com.gyx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Admin
 * @description Created by IntelliJ IDEA.
 * @date 2019/4/2
 */
@RestController
public class TestController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "service1",method = RequestMethod.GET)
    public String  service(){
        return restTemplate.getForObject("http://service2/service2",String.class);
    }
}
