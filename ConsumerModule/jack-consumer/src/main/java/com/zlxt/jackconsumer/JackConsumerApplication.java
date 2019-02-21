package com.zlxt.jackconsumer;

import com.zlxt.jackconsumer.feign.ProviderJackFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RestController
//@RequestMapping("/consumerJack")
public class JackConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JackConsumerApplication.class, args);
    }

    @Autowired
    private ProviderJackFeign providerJackFeign;

    @GetMapping("/hello")
    public String hello(@RequestParam String param){
        return providerJackFeign.hello(param);
    }

}
