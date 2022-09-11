# gulimall

### 介绍

谷粒商城  [Java项目《谷粒商城》Java架构师 | 微服务 | 大型电商项目_哔哩哔哩_bilibili](https://www.bilibili.com/video/BV1np4y1C7Yf?from=search&seid=2752521881830072692&spm_id_from=333.337.0.0)



### 项目演示

#### 后台管理系统

项目演示地址： [http://codekenan.icu/gulimall](http://codekenan.icu/gulimall)  

#### 前台商城系统

项目演示地址： [http://codekenan.icu:10001](http://codekenan.icu:10001)




### 组织结构

``` lua
gulimll
├── gulimall-auth-server -- 认证服务
├── gulimall-common -- 工具类及通用代码
├── gulimall-coupon -- 优惠服务
├── gulimall-gateway -- 网关
├── gulimall-member -- 会员服务
├── gulimall-order -- 订单服务
├── gulimall-product -- 商品服务
├── gulimall-search -- 基于Elasticsearch的商品搜索服务
├── gulimall-third-party -- 第三方服务
├── gulimall-ware -- 仓储服务
├── renren-fast -- 登录验证，token
└── renren-generator -- 代码生成
```


### 架构

#### 系统架构

![](http://codekenan.icu/img/谷粒商城-微服务架构图.jpg)

#### 业务架构

![](http://codekenan.icu/img/业务架构.png)



### 技术选型

#### 后端技术

| 技术           | 说明                | 官网                                           |
| -------------- | ------------------- | ---------------------------------------------- |
| SpringBoot     | 容器+MVC框架        | https://spring.io/projects/spring-boot         |
| SpringSecurity | 认证和授权框架      | https://spring.io/projects/spring-security     |
| MyBatis        | ORM框架             | http://www.mybatis.org/mybatis-3/zh/index.html |
| Elasticsearch  | 搜索引擎            | https://github.com/elastic/elasticsearch       |
| RabbitMQ       | 消息队列            | https://www.rabbitmq.com/                      |
| Redis          | 分布式缓存          | https://redis.io/                              |
| Kibana         | 日志可视化查看工具  | https://github.com/elastic/kibana              |
| Nginx          | 静态资源服务器      | https://www.nginx.com/                         |
| Docker         | 应用容器引擎        | https://www.docker.com                         |
| Druid          | 数据库连接池        | https://github.com/alibaba/druid               |
| OSS            | 对象存储            | https://github.com/aliyun/aliyun-oss-java-sdk  |
| JWT            | JWT登录支持         | https://github.com/jwtk/jjwt                   |
| Lombok         | 简化对象封装工具    | https://github.com/rzwitserloot/lombok         |
| Hutool         | Java工具类库        | https://github.com/looly/hutool                |
| PageHelper     | MyBatis物理分页插件 | http://git.oschina.net/free/Mybatis_PageHelper |

#### 前端技术

| 技术       | 说明             | 官网                           |
| ---------- | ---------------- | ------------------------------ |
| Vue        | 前端框架         | https://vuejs.org/             |
| Vue-router | 路由框架         | https://router.vuejs.org/      |
| Vuex       | 全局状态管理框架 | https://vuex.vuejs.org/        |
| Element    | 前端UI框架       | https://element.eleme.io       |
| Axios      | 前端HTTP框架     | https://github.com/axios/axios |

