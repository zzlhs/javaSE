## AOP
	aop的思想实现一般都是基于代理模式，在java中一般采用jdk动态代理模式，但是jdk
动态代理模式只能代理接口不能类，所以
 a 目标对象的实现类实现了接口 ---> jdk动态代理来生成aop代理类
 b 目标对象的实现类没有实现接口 ---> Cglib来生成Aop代理类（对开发者完全透明）
  
## aop相关术语

	Aspect：一个关注点的模块化，这个关注点可能会横切多个对象。
	
	Joinpoint：程序执行过程中某个特定的点，比如某方法调用的时候或者处理异常的时候。
	
	Advice：在切面的某个特定的连接点上执行的动作（5种）
		Bfore advice
		After returning advice
		After throwing advice
		After(finally) advice
		Around advice
		
	
	Pointcut：连接点被匹配上即变为切入点
	
	Target：目标对象
	
	Weaving：动作应到到目标对象的过程（运行时完成）