package com.zlxt.roseconsumer;

import com.zlxt.roseconsumer.feign.ProviderRoseFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
//@RequestMapping("/consumerRose")
public class RoseConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoseConsumerApplication.class, args);
    }

    @Autowired
    private ProviderRoseFeign providerRoseFeign;

    @Value("${server.port}")
    private String port;

    @GetMapping("/hello")
    public String hello(@RequestParam String param){
        return "[rose.consumer]，port：" + port + "，" + providerRoseFeign.hello(param);
    }


}
