## 1 运行时数据区域

Program Counter Register 程序计数器  
VM Stack 虚拟机栈  
Native Method Stack  
Heap  
Method Area  

其中前3个都是线程私有的，后面2个是所有线程共享的  

### Program Counter Register 程序计数器

如果线程执行的是java方法，则 Program Counter Register 记录的是正在执行的虚拟机字节码指令的地址，如果正在执行的是Native方法，这个计数器的值为 undefined；此运行时数据区域时唯一一块不会有OOM的区域   

### VM Stack 虚拟机栈

VM Stack 描述的时java方法执行的内存模型，随着java方法的执行VM Stack中的栈帧进行着出栈与入栈的操作 **我们平常说的栈和堆中的栈就是这个VM Stack或者说时VM Stack的局部变量表部分，**
局部变量表中存放了编译期间可知的各种基本数据类型和对象引用；java虚拟机规范中对这个区域规定了2种异常 stackOverFlow和OOM

### Native Method Stack 

Native Method Stack 描述的是java的Native方法的内存模型，除次以外其他与VM Stack基本一致

### Heap

主要是生成对象实例及数组的数据区域，一般可分为新生代/老年代，再详细的可以分为Eden、from survivor、to survivor等；如果堆中没有内存可以分配实例将会抛出OOM

### Method Area

主要用于存储已被虚拟机加载的类信息、常量、静态变量、即时编译器编译后的代码等数据，当方法区无法满足内存分配需求时，会OOM

### 运行时常量池

是方法区的一部分，OOM

### 直接内存

nio等的缓冲区，使我们再缓冲时不用再占用jvm的内存数据区域

## 2 对象探秘

### 对象的创建 就是 new时

1 首先去检查这个指令的参数是否能在常量池中定位到一个符号的引用，并检查这个符号的类是否已被加载、解析和初始化过；如果没有，需要进行必要的类加载检查  
2 类加载检查后，jvm就知道了对象的大小，于是分配内存    
	指针碰撞 空闲列表 ----> java堆是否规整 ----> gc是否带有垃圾回收算法  
3 初始化零值，例如Inerger的零值为0为了保障我们创建对象后不需赋值即可使用  
4 虚拟机对对象进行必要的设置，如hashCode、如何才能找到元数据信息、对象的gc分代年龄、对象时哪个类的实例等    

## 3 相关的jvm参数

| jvm参数 | 参数作用 | 备注 |
| ------- | -------- | ---- |
| -Xms20m | Heap最小值 |
| -Xmx20m | Heap最大值 |
| -Xmn10m | heap中给新生代的大小 | 同理设置了此参数也就相当于设置老年代的大小 |
| -XX:SurvivorRatio=8 | 新生代中一个Eden与survivor的大小比为8 |
| -XX:PretenureSizeThreshold=72381 | 大于这个设置值的对象直接再老年代分配 |  
| -XX:+HeapDumpOnOutOfMemoryError | HeapDump |
| -XX:HeapDumpPath=D:\workspaces\dump\heapdump.hpro | HeapDump生成名称 |
| -Xss128k | 虚拟机栈和本地方法栈 |
| -XX:PermSize=10m | 方法区大小 |
| -XX:MaxPermSize=12m | 方法区最大 |
| -XX:MaxDirectMemorySize=10m | 直接内存 | 当不设置直接内存的jvm参数时，直接内存默认与jvm的最大堆大小一致 |
| -XX:PrintGCDetails | 打印gc日志 |
| -XX:MaxTenuringThreshold=2 | 对象晋升老年代的年龄阈值，默认为15 |

## 4 垃圾收集&内存分配

### 如何判断对象死亡？

引用计数法 --> 成熟的语言一般不使用，因为无法解决两个对象互相引用的情况  

可达性分析 --> 当对象与GC Root没有链接时  

#### java对象中可以作为可达性分析的对象
 
1 虚拟机栈  
2 Method Area  
3 Native Method Stack  

### 引用类型

Strong Reference：强引用，new的对象，即使oom GC也不会回收它  
Soft Reference：软引用，一些还有用但非必须的对象，在系统发生内存溢出之前，会把这些对象列进回收范围进行二次回收，如果这次还没有足够的内存就会发生内存溢出  
Weak Reference：弱引用，当下一次gc时，无论怎么样，属于弱引用的引用都会被回收  
Phantom Reference：吓人的引用，没有什么用，就是当gc时收到一个系统通知  














