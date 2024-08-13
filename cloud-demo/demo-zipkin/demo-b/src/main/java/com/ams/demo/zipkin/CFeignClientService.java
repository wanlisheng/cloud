package com.ams.demo.zipkin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(value = "demo-c")
@RequestMapping("/")
public interface CFeignClientService {

    @RequestMapping("/testC")
    String test();
}
