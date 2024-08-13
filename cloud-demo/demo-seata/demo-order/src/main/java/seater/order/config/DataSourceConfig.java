//package seater.order.config;
//
//import org.apache.shardingsphere.driver.api.yaml.YamlShardingSphereDataSourceFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//import java.io.IOException;
//import java.io.InputStream;
//
//@Configuration
//public class DataSourceConfig {
//
//    @Bean
//    public DataSource dataSource() throws IOException {
//        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sharding-databases.yml")) {
//            if (inputStream == null) {
//                throw new IOException("sharding-databases.yml not found in classpath");
//            }
//            return YamlShardingSphereDataSourceFactory.createDataSource(inputStream);
//        }
//    }
//}