package com.zlxt.roseconsumer.feign.hystrix;

import com.zlxt.roseconsumer.feign.ProviderRoseFeign;
import org.springframework.stereotype.Component;

@Component
public class ProviderRoseHystrix implements ProviderRoseFeign {

    @Override
    public String hello(String param) {
        return "sorry，this service had die，param：" + param;
    }
}
