package com.ams.demo.zipkin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(value = "demo-b")
public interface BFeignClientService {

    @RequestMapping("/testB")
    String test();
}
