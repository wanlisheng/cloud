package seater.storage;

import io.seata.config.springcloud.EnableSeataSpringConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@SpringBootApplication(exclude = TransactionAutoConfiguration.class)
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableSeataSpringConfig
public class DemoStorageApp {
    public static void main(String[] args) {
        SpringApplication.run(DemoStorageApp.class, args);
    }
}
