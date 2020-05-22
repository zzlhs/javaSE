## spring的学习

### 1 spring 一站式框架
	WEB层： SpringMVC
	Service层：Spring的Bean管理，Spring声明式事务
	DAO层：Spring的Jdbc模板，Spring的ORM模块

### 2 IOC Inversion of Control(控制反转)
	将对象的创建权反转给（交给）Spring

#### 2.1 DI(依赖注入)
	前提必须有IOC的环境，Spring管理这个类的时候将类的依赖的属性注入（设置）进来
#### 2.2 spring中的工厂类
	BeanFactory --> 老版本的工厂类，调用getBean的时候，才会生成类的实例
	
	ApplicationContext --> 新版本的工厂类有两个实现类
		ClassPathXmlApplicationContext
		FileSystemXmlApplicationContext
		
### 3 Bean的相关配置

#### 3.1 一般情况下用id，极少数情况下用name
	id 唯一约束
	name 非唯一约束，开发中极少使用
	
#### 3.2 生命周期的配置 
	@Bean(initMethod="init", destroyMethod="destroy")
	
	构造方法的注入
	普通属性的注入
	
### 4 AOP相关 
	底层使用的动态代理机制
	作用：权限校验、日志记录、性能监控、事务控制

#### 4.1 横向抽取之动态代理（实现）
	JDK动态代理： 只能对实现了接口的类产生代理
	
	Cglib动态代理： 对没有实现接口的类产生代理，生成类对象

#### 4.2 AOP开发相关术语
	Joinpoint ---> 拦截点，可以被拦截到的点
	Pointcut ---> 切入点，真正被拦截到的点
	Advice ---> （方法层面）拦截到Joinpoint之后要做的事情，可分为
前置~、后置~、异常~、最终~、环绕~
	Introduction ---> 类层面
	Target ---> 被增强的对象
	Weaving ---> advice应用到target的过程
	
	Proxy
	Aspect ---> 多个advice和多个Pointtut的组合

### 5 事务相关

#### 5.1 Spring中提供了7种事务的传播行为

	保证多个操作在同一个事务中
		PROPAGATION_REQUIRED ---> 默认值，如果A中有事务，使用A中的事务，如果A没有，创建一个新的事务，将操作包含进来
		PROPAGATION_SUPPORTS ---> 支持事务，如果A中有事务，使用A中的事务。如果A没有事务，不使用事务。
		PROPAGATION_MANDATORY ---> 如果A中有事务，使用A中的事务。如果A没有事务，抛出异常。

	保证多个操作不在同一个事务中
		PROPAGATION_REQUIRES_NEW ---> 如果A中有事务，将A的事务挂起（暂停），创建新事务，只包含自身操作。如果A中没有事务，创建一个新事务，包含自身操作。
		PROPAGATION_NOT_SUPPORTED ---> 如果A中有事务，将A的事务挂起。不使用事务管理。
		PROPAGATION_NEVER ---> 如果A中有事务，报异常。

	嵌套式事务
		PROPAGATION_NESTED ---> 嵌套事务，如果A中有事务，按照A的事务执行，执行完成后，设置一个保存点，执行B中的操作，如果没有
	异常，执行通过，如果有异常，可以选择回滚到最初始位置，也可以回滚到保存点。
	
#### 5.2 事务管理相关api
	PlatformTransactionManager 平台事务管理器
		DataSourceTransactionManager
		HibenateTrancsactinManager
	
	TransactionDefinition 事务定义信息
		包括隔离级别、超时信息、传播行为、是否只读
		
	TransactionStatus 事务的状态，用于记录在事务管理过程中，事务状态的对象
		

#### 编程式事务

#### 声明式事务 
	
##### xml
	
	
##### 注解

### 常用注解

#### IOC相关

@Component(value = "") ---> 修饰一个类，将这个类交给Spring管理,value中写的就是id值
	@Controller
	@Service
	@Repository


#### bean相关
@Bean ---> 直接注解bean
@Bean(initMethod="init", destroyMethod="destroy") ---> 生命周期的体现
@PostConstruct
@PreDestroy

@Scope ---> 作用范围
	singleton 默认
	prototype
	request
	session
	globalsession

#### 属性注入相关 
@Value(value = "") ---> 普通属性的注入
@Autowired ---> 按照类型进行属性注入
	@Qualifier(value = "") --> 与@Autowired 按名称进行属性注入
@Resource ---> 按照名称进行注入

#### aop相关注解
其中所有的advice都可以获得JoinPoint，还有2个特殊的下面已标出
@Before(value = "")
@AfterReturning(value = "", returning= "")
@Around(value = "") // 注意这个方法的参数是ProceedingJoinPoint 
@AfterThrowing(value = "",throwing = "")
@After(value = "")

#### 事务相关注解
配置事务管理器
@Transaction ---> sprinBoot 直接使用这个即可 

### 不会用的注解
@ComponentScan



