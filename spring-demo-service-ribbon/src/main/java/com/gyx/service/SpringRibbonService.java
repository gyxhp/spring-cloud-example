package com.gyx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by hp on 2018/7/2.
 */
@Service
public class SpringRibbonService {

    @Autowired
    RestTemplate restTemplate;

    public String port(){
        return restTemplate.getForObject("http://SPRING-DEMO-SERVICE/port",String.class);
    }

}
