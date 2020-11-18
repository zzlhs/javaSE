[toc]
### 1章 基础

#### 1 打印语句查看

主要处理一些语法错误

#### 2 通用查询日志

5.1版本后可以临时打开通用日志记录

#### 3 sql语句优化
先 EXPLAIN EXTENDED 然后 SHOW WARNINGS 这样使用  

https://blog.csdn.net/jobschen/article/details/50878854
第一条命令的结果字段

1. id:
2. select_type:  
	1、SIMPLE： 简单SELECT(不使用UNION或子查询)  
	2、PRIMARY： 最外面的SELECT  
	3、UNION：UNION中的第二个或后面的SELECT语句  
	4、DEPENDENT UNION：UNION中的第二个或后面的SELECT语句，取决于外面的查询  
	5、UNION RESULT：UNION的结果  
	6、SUBQUERY：子查询中的第一个SELECT  
	7、DEPENDENT SUBQUERY：子查询中的第一个SELECT，取决于外面的查询  
	8、DERIVED：导出表的SELECT(FROM子句的子查询)  
3. table:
4. type:
5. possible_keys:
6. key:
7. key_len:
8. ref:
9. rows:
10. filterd:
11. Extra:

4 

#### 5 慢查询的优化 


第二条命令的结果字段
  
1. Level: 一般为Note
2. Code:一般为1003
3. Message: 优化后的结果










 
## 1 优化终点

1.1 直接的select  
```
select * from table_name
```

1.2 on / where / group by 的使用  

使用explain
非唯一的行永远不会产生eq_ref或者更好的类型

1.3 比较表中只有一行记录和表中超过50%的行都有相同记录，在后者中，使用index或降低性能

频繁插入的表带有索引会降低性能





