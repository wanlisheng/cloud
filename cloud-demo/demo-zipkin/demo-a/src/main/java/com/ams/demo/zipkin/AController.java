package com.ams.demo.zipkin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.loadbalancer.RetryableFeignBlockingLoadBalancerClient;
import org.springframework.cloud.sleuth.internal.SleuthContextListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
@Slf4j
@RequiredArgsConstructor
public class AController {
    private final BFeignClientService bFeignClientService;
    @RequestMapping("/test")
    public String test(){
        log.info("我是A服务");
        return bFeignClientService.test();
    }
}
