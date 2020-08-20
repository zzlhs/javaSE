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

VM Stack 描述的时java方法执行的内存模型，随着java方法的执行VM Stack中的栈帧进行着出栈与入栈的操作<font color="red">我们平常说的栈和堆中的栈就是这个VM Stack或者说时VM Stack的局部变量表部分，</font>
局部变量表中存放了编译器可知的各种基本数据类型和对象引用；java虚拟机规范中对这个区域规定了2中异常 stackOverFlow和OOM

### Native Method Stack 

Native Method Stack 描述的时java的Native方法的内存模型，初次以为其他与VM Stack基本一致

### Heap

主要时生成对象实例的数据区域，一般可分为新生代/老年代，再详细的可以分为Eden、from survevor、to servivor等

### Method Area

### 运行时常量池

### 直接内存

nio等的缓冲区，使我们再缓冲时不用再占用jvm的内存数据区域

## 2 对象探秘

### 对象的创建

1 进行必要的类加载检查
2 类加载检查后，jvm就知道了对象的大小，于是分配内存
3 初始化零值，例如Inerger的零值为0为了保障我们创建对象后不需赋值即可使用
4 进行必要信息的填充，如hashCode等

## 3 相关的jvm参数

| -Xms | Heap最小值 |
| -Xmx | Heap最大值 |
| -Xss ||
| -permSize ||
| -maxPermSize ||
| -directMemorySize ||








