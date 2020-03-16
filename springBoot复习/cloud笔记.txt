1 Eureka ---> 可以去github上看看

 遵循AP原则
	CAP


 主管服务的注册与发现
 
 自我保护机制
	某时刻某一个微服务不可用了，enreka不会立刻清理，依旧会对该微服务的
 信息进行保存
	

2 Ribbon负载均衡
	
	一套 客户端 负载均衡 的工具
	
	7种自带算法	
		a 轮询（默认）---> RoundRobinRule
		b 随机 ---> RandomRule
		c 重试 ---> RetryRule
	
	自定义负载算法 ---> 不是很难
	

3 Feign负载均衡
	
	Feign的来历
		a 微服务名字获得通用接口
		
		b 就是通过接口+注解获得我们的调用服务 ---> 符合这条要求
		
		
4 Hystrix 熔断器
	


------------------------------->
@CommmentScan() 主启动类






	

