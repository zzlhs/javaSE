## jdk中锁
	1 synchronized
	2 lock --> https://www.cnblogs.com/dolphin0520/p/3923167.html
	关于lock可以去看相关的博客
	其中介绍了Lock、ReenTrantLock、ReadWriteLock、ReentrantReadWriteLock
	

## 一、jdk的并发容器总结


	jdk提供的容器大部分在java.util.concurrent上
	
	ConcurrentHashMap --> 线程安全的HashMap
	https://www.cnblogs.com/chengxiao/p/6842045.html 源码分析
	
	CopyOnWriteArrayList --> 线程安全的List，在读多写少的场合性能非常好，效率高于Vector
	