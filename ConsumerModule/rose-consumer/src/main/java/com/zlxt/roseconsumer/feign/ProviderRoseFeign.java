package com.zlxt.roseconsumer.feign;

import com.zlxt.roseconsumer.feign.hystrix.ProviderRoseHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "provider-rose", fallback = ProviderRoseHystrix.class)
public interface ProviderRoseFeign {

    @GetMapping("/hello")
    public String hello(@RequestParam String param);

}
