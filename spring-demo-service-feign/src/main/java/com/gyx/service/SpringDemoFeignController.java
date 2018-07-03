package com.gyx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hp on 2018/7/3.
 */
@RestController
public class SpringDemoFeignController {

    @Autowired
    SpringDemoFeignService springDemoFeignService;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String port() {
        return springDemoFeignService.hello();
    }


}
