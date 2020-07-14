1  java.sql.SQLException: Unknown system variable 'transaction_isolation'
一般就是mysql驱动包与mysql数据不配置导致（mysql驱动包版本高而mysql数据库版本低或mysql驱动包版本低而mysql数据库版本高都有可能发生）

2 Invalid default: public abstract java.lang.Class org.mybatis.spring.annotati
这个错是因为
		<dependency>
		    <groupId>org.mybatis.spring.boot</groupId>
		    <artifactId>mybatis-spring-boot-starter</artifactId>
		    <version>2.1.0</version>
		</dependency>
		这个依赖和springBoot版本之间不兼容