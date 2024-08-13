//package seater.order.config;
//
//import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
//import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration // 表示这是一个配置类
//public class MybatisPlusConfig {
//
//    @Bean // 定义一个 Bean，Spring 容器会管理这个 Bean
//    public MybatisPlusInterceptor mybatisPlusInterceptor() {
//        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
//
//        // 添加分页拦截器
//        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
//
//        return interceptor; // 返回拦截器实例
//    }
//}