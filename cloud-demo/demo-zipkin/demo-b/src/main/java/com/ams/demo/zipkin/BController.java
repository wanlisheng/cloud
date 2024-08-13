package com.ams.demo.zipkin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BController {
    private final CFeignClientService cFeignClientService;
    @RequestMapping("/testB")
    public String test(){
        log.info("我是B服务");
        return cFeignClientService.test();
    }
}
