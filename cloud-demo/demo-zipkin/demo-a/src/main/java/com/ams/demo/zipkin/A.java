package com.ams.demo.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import zipkin2.reporter.AsyncReporter;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackageClasses = {BFeignClientService.class})
public class A {
    public static void main(String[] args) {
        SpringApplication.run(A.class,args);
    }
}
