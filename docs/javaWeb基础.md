### 1 Servlet介绍

#### 特性
	1 servlet是非线程安全的（servlet是单例的），也正是因为是非线程安全的，所以servlet的效率高
	2 每个servlet都是唯一的，他们处理的请求是不同的
	
#### servlet中的行为：
	1 接收请求数据
	2 处理请求
	3 完成响应
	
#### 实现servlet的3种方式：
	1 实现 Servlet接口
	2 继承GenericServlet类
	3 继承HttpServlet类
##### HttpServlet介绍
	要知道httpServlet的调用时序图（调用过程）
	
	
	
#### Servlet接口中的方法（5个）
	init() 第一次被请求时创建servelt执行，且只执行一次
	service()
	destroy() 服务器关闭时执行，且只执行一次
	getServletConfig()
	getServletInfo()
	
#### ServletConfig？（也是一个接口）
	获取响应web.xml中servlet中的配置信息
	
	随便写几它的个方法？
	getServletName()
	getServletContext()
	
#### Servlet细节

	1 不要在servlet中创建成员
	2 可以创建无状态成员
	3 可以创建有状态成员，但状态必须是只读的
	
#### Servlet与反射

#### ServletContext？（上下文对象）

	一个项目只有一个ServletContext对象！application
	可以在n个servlet中获取这个对象，实现数据的共享
	
	##### 如何获取ServletContext对象
		
		由ServletConfig获取
	
#### 四大域之一 ServletContext 域对象就是用来在多个Servlet中传递数据的功能
	
	ServletContext
	PageContext
	ServletRequest
	HttpSession
	
	##### ServletContext可以获取项目的初始化参数
	
	
### 过滤器 filter

	1 过滤器有拦截器请求的能力
	2 Filter是单例的 
	
#### 如何编写？
	1 继承filter接口
	2 web.xml中配置
	
#### filter接口中的方法

	init(FilterConfig )
	doFilter()
	destroy(ServletRequest, ServletResponse, FilgerChain);
	
#### filter的4中拦截方式
	dispatcher
	请求 request(默认的 )
	转发 forward
	包含 include
	错误 error
	
	 
	
	
	
	

	