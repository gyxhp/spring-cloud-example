package com.gyx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class SpringSleuthService2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSleuthService2Application.class, args);
	}

	@RequestMapping(value = "service2",method = RequestMethod.GET)
	public String service2(){
		return "Hello , I'm service2 !";
	}

}
