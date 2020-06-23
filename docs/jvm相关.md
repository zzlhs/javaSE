
## jvm的内存区域

### 1 程序计数器 ~

	线程私有，如果线程执行的是java方法，~会记录正在执行的虚拟机字节码指令的地址；如果执行的是native方法，
则~的值是undefined

	此区域没有规定任何OOM异常

### 2 虚拟机栈 ~

	线程私有，~的生命周期与线程相同，存储的是局部变量、操作数栈、动态链接等，~描述的是java方法执行的内存模型：每个方法在执行的时候都会创建一个
栈帧(Stack Frame),每一个方法从调用直至执行完成的过程，就对应一个栈帧在虚拟机中入栈到出栈的过程
	
	StackOverflowError
	OOM
	
#### 相关虚拟机参数及使用 虚拟机栈和本地方法栈通用

	-Xss
	
### 3 本地方法栈

	native方法，其他与虚拟机栈类似
	
### 4 java堆 ~

	线程共享，所有的对象实例聚集地~，内部可化为Eden、From Survivor、To Survivor
	
	OOM
	
#### 相关虚拟机参数及使用
	
	-Xmx 堆的最大值
	-Xms 堆的最小值
	-XX:+HeapDumpOnOutOfMemoryError jvm在出现内存溢出时Dump出当前的dump
	

### 5 方法区

	线程共享，用于存储已被虚拟机加载的类信息、常量、静态变量、即时编译器编译后的代码等数据

#### 相关虚拟机参数及使用 方法区和运行时常量池通用

	-XX:PermSize
	-XX:MaxPermSize

### 其他虚拟机参数设置

	本地直接内存
	-XX:MaxDirectMemorySize 如果不指定默认将与 Xmx 一样大

### 附上一个例子

-vmargs
-Xms256m 最小堆内存
-Xmx256m 最大堆内存
-XX:PermSize=64m 最小非堆内存
-XX:MaxPermSize=64m 最大非堆内存
-Djava.library.path=./interface/engine
-Xverify:none
-verbose:gc 
-Xloggc:./log/gc.log
-XX:+PrintGCDetails 打印出gc细节
-XX:+PrintGCTimeStamps 打印出gc细节对应的时间点
	
	
	
	