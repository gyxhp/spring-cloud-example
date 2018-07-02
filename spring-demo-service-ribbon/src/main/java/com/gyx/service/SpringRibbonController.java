package com.gyx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hp on 2018/7/2.
 */
@RestController
public class SpringRibbonController {

    @Autowired
    SpringRibbonService springRibbonService;

    @RequestMapping(value = "hello")
    private String port(){
        return springRibbonService.port();
    }

}
