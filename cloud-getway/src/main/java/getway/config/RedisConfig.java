//package getway.config;
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
//import org.redisson.api.RMap;
//import org.springframework.boot.autoconfigure.AutoConfigureBefore;
//import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
////import org.springframework.core.io.ClassPathResource;
////import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
////import org.springframework.data.redis.core.RedisTemplate;
////import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
////import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//import org.redisson.Redisson;
//import org.redisson.api.RedissonClient;
//import org.redisson.config.Config;
//
//import java.io.IOException;
//import java.io.InputStream;
//
//
//@Configuration
//public class RedisConfig {
//
////    @Bean("redisSentinelClient")
////    public RedissonClient redisSentinelClient(){
////        Config config = null;
////        try {
////            InputStream inputStream = new ClassPathResource("/redisson-config/sentinel.yaml").getInputStream();
////            config = Config.fromYAML( new ClassPathResource("/redisson-config/sentinel.yaml").getInputStream());
////            System.out.println("aaaa");
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////
////        return Redisson.create(config);
////    }
//    @Bean
//    public RedissonClient redissonClient() {
//        Config config = new Config();
//        config.useSentinelServers()
//                .setMasterName("mymaster")
//                .addSentinelAddress("redis://192.168.198.130:26379", "redis://192.168.198.132:26380")
//                .setPassword("12345678");
////        return Redisson.create(config);
////
//        RedissonClient redisson = Redisson.create(config);
//
//        // 使用 RedissonClient
//        // 示例：获取一个 RMap 对象
//        RMap<String, String> map = redisson.getMap("myMap");
////        map.put("key", "value");
//        String myMap = map.get("key");
//
//        // 关闭 RedissonClient
//        redisson.shutdown();
//        return Redisson.create(config);
//    }
//
//}
