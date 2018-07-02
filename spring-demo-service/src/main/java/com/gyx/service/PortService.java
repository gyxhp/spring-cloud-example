package com.gyx.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hp on 2018/7/2.
 */
@RestController
public class PortService {
    @Value("${server.port}")
    String port;

    @RequestMapping("port")
    public String getPort() {
        return "Hello World, I'm from port : " + port;
    }

}
