package com.zlxt.jackconsumer.feign.hystrix;

import com.zlxt.jackconsumer.feign.ProviderJackFeign;
import org.springframework.stereotype.Component;

@Component
public class ProviderJackHystrix implements ProviderJackFeign {

    @Override
    public String hello(String param) {
        return "sorry，this service had die，param：" + param;
    }

}
