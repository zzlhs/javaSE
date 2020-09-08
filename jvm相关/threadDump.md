## ThreadDump

JVM所有线程在某一点的状态，包含线程、线程的运行状态、标识和调用的堆栈。  

## ThreadDump生成方法

	Linux下生成JVM的ThreadDump可以通过以下指令：  
	jstack -l 【PID】 > 【文件名】  
	如图：  
	
## 可以使用eclipse的jar包进行查看