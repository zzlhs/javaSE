### Filter 

常用于 记录日志、排除有xss威胁的字符，执行权限验证等

#### 使用方法

1 多注意相关注解的使用
	```
	@Order(1) //order中的值越小越先执行
	@WebFilter(urlPatterns = "/*",filterName = "filter2",initParams = { @WebInitParam(name = "name1", value = "zyf1"), 
		@WebInitParam(name = "name2", value = "zyf2")})
	public class FilterAnnotationTest implements Filter{

		@Override
		public void init(FilterConfig filterConfig) throws ServletException {
			System.out.println("初始化过滤器");
		}
	

		@Override
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
				throws IOException, ServletException {
			System.out.println("过滤器开始工作...");
			chain.doFilter(request, response);
		}

		@Override
		public void destroy() {
			System.out.println("过滤器销毁");
		}

	}
	```
	
	```
	@ServletComponentScan // 与filter使用配套
	public class zyfAop {
		public static void main(String[] args) {
			SpringApplication.run(zyfAop.class, args);
		}
	}
	```
	
	255 + 88.74 255
	
根据不同级别记录不同文件中
log4j.rootLogger=info,stdout,info,debug,error
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=[%-5p] [%d{HH:mm:ss}] %c - %m%n
 
log4j.logger.info=info
org.apache.log4j.DailyRollingFileAppender
 
log4j.logger.debug=debug
log4j.appender.debug=org.apache.log4j.DailyRollingFileAppender
log4j.appender.debug.layout=org.apache.log4j.PatternLayout
log4j.appender.debug.layout.ConversionPattern=[%-5p] [%d{HH:mm:ss}] %c - %m%n
log4j.appender.debug.datePattern='.'yyyy-MM-dd
log4j.appender.debug.Threshold = DEBUG 
log4j.appender.debug.append=true
log4j.appender.debug.File=e:/logs/debug.log
 
log4j.logger.error=error
log4j.appender.error=org.apache.log4j.DailyRollingFileAppender
log4j.appender.error.layout=org.apache.log4j.PatternLayout
log4j.appender.error.layout.ConversionPattern=[%-5p] [%d{HH:mm:ss}] %c - %m%n
log4j.appender.error.datePattern='.'yyyy-MM-dd
log4j.appender.error.Threshold = ERROR 
log4j.appender.error.append=true
log4j.appender.error.File=e:/logs/error.log 
 
