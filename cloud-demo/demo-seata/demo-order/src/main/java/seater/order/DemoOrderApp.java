package seater.order;


import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
//import org.apache.shardingsphere.core.config.DataSourceConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.annotation.PostConstruct;

@MapperScan("seater.order.dao")
@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
@EnableDiscoveryClient
@EnableFeignClients
public class DemoOrderApp {
    public static void main(String[] args) {
        SpringApplication.run(DemoOrderApp.class, args);
    }

//    @Value("${spring.shardingsphere.datasource.master.url}")
//    private String datasourceUrl;
//
//
//    @PostConstruct
//    public void init() {
//        System.out.println("Datasource URL: " + datasourceUrl);
//    }
}
