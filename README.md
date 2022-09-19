# gulimall

### 项目介绍

​		谷粒商城 

​		[Java项目《谷粒商城》Java架构师 | 微服务 | 大型电商项目_哔哩哔哩_bilibili](https://www.bilibili.com/video/BV1np4y1C7Yf?from=search&seid=2752521881830072692&spm_id_from=333.337.0.0)

​		[接口文档]( https://easydoc.net/doc/75716633/ZUqEdvA4/hKJTcbfd)	

​		谷粒商城，是尚硅谷雷丰阳老师教学的一套B2C商城项目，包括前台商城系统及后台管理系统，基于[人人开源]([人人开源 (gitee.com)](https://gitee.com/renrenio))项目进行二次开发，采用SpringBoot+SpringCloud+SpringCloudAlibaba + MyBatis-Plus实现。

​		前台商城系统包括：用户登录、注册、商品搜索、商品详情、购物车、下订单流程、秒杀活动等模块。后台管理系统包括：系统管理、商品系统、优惠营销、库存系统、订单系统、用户系统、内容管理等七大模块。

​		项目包含前后分离全栈开发、Restful接口、数据校验、网关、注册发现、配置中心，熔断、限流、降级、链路追踪、性能监控、压力测试、系统预警、集群部署、持续集成、持续部署等



### 项目演示

云服务器内存不足，采用单体架构部署 [gulimall: 谷粒商城 (gitee.com)](https://gitee.com/bingkuoluohaohe/gulimall)

#### 后台管理系统

项目演示地址： [admin-vue](http://codekenan.icu/admin-vue/)  

#### 前台商城系统

项目演示地址： [shop-vue](http://codekenan.icu/shop-vue)




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
├── gulimall-search -- 商品搜索服务
├── gulimall-third-party -- 第三方服务
├── gulimall-ware -- 库存服务
├── renren-fast -- 后台管理服务
└── renren-generator -- 代码生成
```



### 项目架构

#### 系统架构

![](http://codekenan.icu/img/谷粒商城-微服务架构图.jpg)

#### 业务架构

![](http://codekenan.icu/img/业务架构.png)



### 技术选型

#### 后端技术

| 技术           | 说明               | 官网                                           |
| -------------- | ------------------ | ---------------------------------------------- |
| SpringBoot     | 容器+MVC框架       | https://spring.io/projects/spring-boot         |
| SpringCloud    | 微服务框架         | https://spring.io/projects/spring-cloud        |
| SpringSecurity | 认证和授权框架     | https://spring.io/projects/spring-security     |
| MyBatis        | ORM框架            | http://www.mybatis.org/mybatis-3/zh/index.html |
| MyBatis-Plus   | MyBatis 增强工具   | https://baomidou.com/                          |
| Nacos          | 注册和配置中心     | https://nacos.io/zh-cn/                        |
| Redis          | 分布式缓存         | https://redis.io/                              |
| Nginx          | 静态资源服务器     | https://www.nginx.com/                         |
| Elasticsearch  | 搜索引擎           | https://github.com/elastic/elasticsearch       |
| Kibana         | 日志可视化查看工具 | https://github.com/elastic/kibana              |
| RabbitMQ       | 消息队列           | https://www.rabbitmq.com/                      |
| Docker         | 应用容器引擎       | https://www.docker.com                         |
| Druid          | 数据库连接池       | https://github.com/alibaba/druid               |
| OSS            | 对象存储           | https://github.com/aliyun/aliyun-oss-java-sdk  |
| JWT            | JWT登录支持        | https://github.com/jwtk/jjwt                   |
| Lombok         | 简化对象封装工具   | https://github.com/rzwitserloot/lombok         |
| 腾讯云短信服务 |                    | https://cloud.tencent.com/search/短信/1_1      |

#### 前端技术

| 技术       | 说明             | 官网                           |
| ---------- | ---------------- | ------------------------------ |
| Vue        | 前端框架         | https://vuejs.org/             |
| Vue-router | 路由框架         | https://router.vuejs.org/      |
| Vuex       | 全局状态管理框架 | https://vuex.vuejs.org/        |
| Element    | 前端UI框架       | https://element.eleme.io       |
| Axios      | 前端HTTP框架     | https://github.com/axios/axios |
| Thymeleaf  | 模板引擎         | https://www.thymeleaf.org/     |
| JQuery     | JavaScript 库    | https://jquery.com/            |



### 致谢

感谢尚硅谷和黑马程序员各位老师的付出

[尚硅谷的个人空间_哔哩哔哩_bilibili](https://space.bilibili.com/302417610?from=search&seid=12005800999082421100&spm_id_from=333.337.0.0)

[黑马程序员的个人空间_哔哩哔哩_bilibili](https://space.bilibili.com/37974444?from=search&seid=12005800999082421100&spm_id_from=333.337.0.0)

<img src="http://www.codekenan.icu/img/qq.jpg" width="250px"/>
<img src="http://www.codekenan.icu/img/wechat.png"/>
