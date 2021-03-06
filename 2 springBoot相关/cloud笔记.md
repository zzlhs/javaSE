
----------------------------
@Configuration 
@Bean
----------------------------
@RestController
@Autowired
@RequestMapping(value="/consumer/dept/add")
----------------------------
@EnableEurekaServer
@EnableEurekaClient
及yml中的配置
----------------------------
@LoadBalanced // ribbon 负载均衡

----------------------------


## 1 Eureka ---> 可以去github上看看

 1.1 遵循AP原则
	NoSql --> cp 
	传统的关系型数据库 --> ca
	Eureka ap
	Zookeeper cp
	C --> Consistency 强一致性
	A --> Availablity 高可用性
	P --> Partition tolerance 分区容错性
	
 1.2 Eureka采用了CS的设计架构。EnrekaServer作为服务注册功能的服务器，他是服务注册中心
	 
	 Eureka的客户端连接到Eureka Server并维持心跳。
 
 1.3 Eureka的架构 
	


 主管服务的注册与发现
 
 自我保护机制
	某时刻某一个微服务不可用了，enreka不会立刻清理，依旧会对该微服务的
 信息进行保存
	
 
## 2 Ribbon负载均衡

### Load Balance
	集中式（偏硬件） ---> F5/nginx
	进程式（偏软件） ---> 消费方
	
	
### Ribbon	一套 客户端 负载均衡 的工具
	#### 1 Ribbon工作中的两步
		第一步先选择EurekaServer，他优先选择在同一个区域内负载均衡较少的server
		第二步再选择用户指定的策略，在从server取到的服务注册列表中选择一个地址
	
	#### 7种自带策略	
		a 轮询（默认的负载均衡算法）---> RoundRobinRule
		b 随机 ---> RandomRule
		c 重试 ---> RetryRule
	
	自定义负载算法 ---> 不是很难
	
	IRule
	
	#### 相关注解
		@RibbonClient 
		@LoadBalance

## 3 Feign负载均衡
	
	#### Feign的来历
		a 微服务名字获得通用接口
		
		b 就是通过接口+注解获得我们的调用服务 ---> 符合这条要求
		
	#### Feign相关
		@FeignClient
		@EnableFeignClients
		
		
		microservicecloud-dept 服务提供者
		MICROSERVICECLOUD-DEPT eureka注册中心
		microservicecloud-dept 
		                                                                                     MICROSERVICECLOUD-DEPT
com.netflix.client.ClientException: Load balancer does not have available server for client: microservicecloud-dept
## 4 Hystrix 熔断器
	程序超时 
	


------------------------------->
@CommmentScan() 主启动类


### 题外话1 *****************************************************
	Eureka 和Zookeeper区别？各自有什么优缺点？
	
	Eureka 采用的ap
	
	zookeeper cp 在选举时会导致服务的不可用
	
	出现网络故障
	1 Eureka不再从注册列表中移除因为长时间没收到心跳而应该过期的服务
	2 Eureka仍然能够接口新服务的注册和查询请求，但是不会被同步到其他节点上（既保证当前节点可用）
	3 当网络恢复后，再同步到其他节点

### 题外话2 *****************************************************
	springcloud和dubbo之间的区别？ 优缺点？
	cp ap
	
	
### 题外话3 *****************************************************

	controller上的注释 当为post请求时 
	
### 
	ContentType: x-www-form-urlencoded
				 form-data

	


	

