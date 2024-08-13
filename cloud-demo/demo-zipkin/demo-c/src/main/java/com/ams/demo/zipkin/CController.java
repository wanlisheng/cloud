package com.ams.demo.zipkin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class CController {
    @RequestMapping("/testC")
    public String test() {
        log.info("我是C服务");
        return "都需要等着我啊";
    }
}
