package com.zlxt.jackconsumer.feign;

import com.zlxt.jackconsumer.feign.hystrix.ProviderJackHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "provider-jack", fallback = ProviderJackHystrix.class)
public interface ProviderJackFeign {

    @GetMapping("/hello")
    public String hello(@RequestParam String param);

}
