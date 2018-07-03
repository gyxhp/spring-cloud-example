package com.gyx.service;

import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hp on 2018/7/3.
 */
@FeignClient(value = "spring-demo-service",fallback = ErrorHystrix.class)  //通过@FeignClient注解指定调用服务
public interface SpringDemoFeignService {

    @RequestMapping(value = "port",method = RequestMethod.GET)   //requestmapping与
    String hello();

}
