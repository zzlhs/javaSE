# javaSE
java基础学习

### 1 锁的分类

#### 1 可重入锁
锁具备可重入，则可成为可重入锁，像synchronized和ReentrantLock都是可重入锁。可重入的意思是
在某类的一个sychronized方法中是可以再调用其他synchronized修饰的方法的。若果不可重入，则会再次申请锁，而此时这个类已经的得到了这个锁，会形成死锁问题
#### 2 可中断锁
可以响应中断的锁，java中synchronized时不可中断锁，即在等待获取锁的过程中是不可以被中断的，lock则为可中断锁，如在lockTest中TestLockInterruptibly.java中关于lockInterruptibly()方法的使用
#### 3 公平锁
即按照请求锁的顺序来获取锁，有多个线程在等待一个锁，当这个锁被释放时，等待时间最久的线程（最先请求的线程）会获得该所，这种就是公平锁。
java中的synchronized是非公平锁
ReentrantLock和ReentrantReadWriteLock，它默认情况下是非公平锁，但是可以设置为公平锁。
#### 4 读写锁
即对文件的访问形式，一个读锁，一个写锁。
可以看 lockTest中TestReentrantReadWriteLock.java 详细了解

### 2 线程的介绍
#### 1 创建线程
可以查看 threadTest中的 代码即可
#### 2 线程的生命周期
![](https://raw.githubusercontent.com/zhengyuanfeng521/javaSE/master/threadState.png)
如图所示，即为完整的线程的生命周期
##### 注意
     a 当用 new 关键字创建了一个线程之后，该线程处于新建状态，此时它和其他的java对象一样，仅有java虚拟机为其分配内存，并初始化其成员变量的值。此时的线程没有表现吃任何的动态特征，程序也不会执行线程的线程执行体。
     b 线程对象调用 start() 后，线程进入就绪状态，java虚拟机会为其创建方法调用栈和程序计数器，处于这个状态的线程还没有开始执行，只是表示该线程可以运行了。何时线程启动取决于jvm里线程调度器的调度。
     c 在调用的线程的run方法后，该线程已经不再处于新建状态，不要再次调用对象的start()，即只能对处于新建状态的线程调用start()方法，否则引发 IlleaglThreadStateException
##### 线程死亡
     run() call() 执行结束，结束后处于死亡状态
     线程抛出一个未捕获的 Exception 或 Error
     直接调用该线程的stop() 来结束一个线程，通常不推荐使用。
     
     测试是否死亡
          isAlive()
          
#### 3 控制线程
##### join() 
     调用线程被阻塞，直到被join()方法加入的join线程执行完为止
##### 后台线程
     .setDeamon(True) 
     如果将某个线程设置为后台线程，必须在该线程启动之前设置
##### sleep()
##### yield()
      歇息一下，让jvm重新调度线程，一般只有与调用线程相同优先级或比调用线程优先级高的线程接着执行
##### 改变线程的优先级

     
     
      
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     


     
  
