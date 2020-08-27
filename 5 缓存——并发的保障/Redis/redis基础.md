
### 1 redis的5种数据类型及常用语句
string  
list  
hash  
set  
zset  

#### 1.1 字符串操作(string)

##### 设置和获取

set   
get  

##### 查看是否存在和删除键
exists --> 是否存在  
del --> 删除  
keys * --> 查出redis中的所有键  

##### 过期设置

expire name(key) 5 --> 5s 后过期  

##### 计数
incr  --> 增加1  
incrby 50 --> 按照步长增加  

#### 1.2 列表

##### 基本操作
	rpush 

	lpush
	
	lrange mylist 0 -1 --> 从第一个元素到最好一个元素
##### 队列（先进先出）
	rpush和lpop即可构成队列
	
	lpush和rpop也可以的
##### 栈
	rpush和rpop
	
#### 1.3 hash
	hset
	hget

#### 1.4 set
	sadd
	
	smembers --> 全部
	
	sismember --> 查询某个value是否存在
	
	scared --> 获取长度
	
	spop --> 弹出一个
	
#### 1.5 zset，它类似于 Java 中 SortedSet 和 HashMap 的结合体，一方面它是一个 set，保证了内部 value 的唯一性，另一方面它可以为每个 value 赋予一个 score 值，用来代表排序的权重。
	zadd   
	
	zrange  
	
	zrevrange  
	 
	zcard  
	
	zscore  
	
	zrem  
	
	



	

	 
	  
	
	
	
	
	









