# cloud




## 项目简介

`mall-swarm`是一套微服务脚手架系统，采用了 Spring Cloud  & Alibaba、Spring Boot 2、Oauth2、MyBatis-plus、sentinel、getway、Seata分布式事务、Shardingjdbc分库分表、redis哨兵、mysql主从、等核心技术。




## 项目架构

### 组织结构

``` lua
cloud
├── cloud-common -- 工具类及通用代码模块
├── cloud-auth -- 基于Spring Security Oauth2的统一的认证中心
├── cloud-gateway -- 基于Spring Cloud Gateway的微服务API网关服务
├── cloud-admin -- 用户相关模块
├── cloud-demo -- 微服务远程调用测试服务
```

## 技术选型

### 后端技术

| 技术                   | 说明                 | 官网                                                 |
| ---------------------- | -------------------- | ---------------------------------------------------- |
| Spring Cloud           | 微服务框架           | https://spring.io/projects/spring-cloud              |
| Spring Cloud Alibaba   | 微服务框架           | https://github.com/alibaba/spring-cloud-alibaba      |
| Spring Boot            | 容器+MVC框架         | https://spring.io/projects/spring-boot               |
| Spring Security Oauth2 | 认证和授权框架       | https://spring.io/projects/spring-security-oauth     |
| MyBatis                | ORM框架              | http://www.mybatis.org/mybatis-3/zh/index.html       |
| PageHelper             | MyBatis物理分页插件  | http://git.oschina.net/free/Mybatis_PageHelper       |
| Knife4j                | 文档生产工具         | https://github.com/xiaoymin/swagger-bootstrap-ui     |
| Redis                  | 分布式缓存           | https://redis.io/                                    |
| Druid                  | 数据库连接池         | https://github.com/alibaba/druid                     |
| JWT                    | JWT登录支持          | https://github.com/jwtk/jjwt                         |
| Lombok                 | 简化对象封装工具     | https://github.com/rzwitserloot/lombok               |
| Seata                  | 全局事务管理框架     | https://github.com/seata/seata                       |




