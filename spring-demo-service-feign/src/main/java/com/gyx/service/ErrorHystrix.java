package com.gyx.service;

import org.springframework.stereotype.Component;

/**
 * Created by hp on 2018/7/3.
 */
@Component
public class ErrorHystrix implements SpringDemoFeignService {

    @Override
    public String hello() {
        return "serry , it's error!";
    }
}
