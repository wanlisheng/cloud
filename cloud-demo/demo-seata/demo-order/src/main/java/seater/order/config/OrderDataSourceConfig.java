//package seater.order.config;
//
//import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
//@Configuration
//// 扫描订单数据库相关的Mapper接口，并指定使用orderSqlSessionFactory
//@MapperScan(basePackages = "seater.order.dao", sqlSessionFactoryRef = "orderSqlSessionFactory")
//public class OrderDataSourceConfig {
//
//    // 配置订单数据库的数据源
//    @Bean(name = "orderDataSource")
//    @ConfigurationProperties(prefix = "spring.shardingsphere.datasource")
//    public DataSource orderDataSource() {
//        return DruidDataSourceBuilder.create().build();
//    }
//
//    // 配置订单数据库的SqlSessionFactory
//    @Bean(name = "orderSqlSessionFactory")
//    public SqlSessionFactory orderSqlSessionFactory(@Qualifier("orderDataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource);
//        sessionFactory.setMapperLocations(
//                new PathMatchingResourcePatternResolver().getResources("classpath:mapper/order/*.xml"));
//        return sessionFactory.getObject();
//    }
//
//    // 配置订单数据库的事务管理器
//    @Bean(name = "orderTransactionManager")
//    public DataSourceTransactionManager orderTransactionManager(@Qualifier("orderDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//}