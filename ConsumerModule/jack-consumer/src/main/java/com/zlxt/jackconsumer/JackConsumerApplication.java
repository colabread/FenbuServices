package com.zlxt.jackconsumer;

import com.zlxt.jackconsumer.feign.ProviderJackFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RestController
@RefreshScope   //消息总线刷新
public class JackConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JackConsumerApplication.class, args);
    }

    @Autowired
    private ProviderJackFeign providerJackFeign;

    @Value("${server.port}")
    private String port;

    @GetMapping("/hello")
    public String hello(@RequestParam String param) {
        return "[jack.consumer]，port：" + port + "，" + providerJackFeign.hello(param);
    }

    @Value("${user.userName}")
    private String userName;

    @Value("${feign.hystrix.enabled}")
    private String hystrix;

    @GetMapping("/user")
    public String user() {
        return "userName:" + userName + " hystrix:" + hystrix;
    }

}
