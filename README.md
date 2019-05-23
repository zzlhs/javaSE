# javaSE
java基础学习

### 锁的分类

#### 可重入锁
锁具备可重入，则可成为可重入锁，像synchronized和ReentrantLock都是可重入锁。可重入的意思是
在某类的一个sychronized方法中是可以再调用其他synchronized修饰的方法的。若果不可重入，则会再次申请锁，而此时这个类已经的得到了这个锁，会形成死锁问题
#### 可中断锁
可以响应中断的锁，java中synchronized时不可中断锁，即在等待获取锁的过程中是不可以被中断的，lock则为可中断锁，如在lockTest中TestLockInterruptibly.java中关于lockInterruptibly()方法的使用
#### 公平锁
即按照请求锁的顺序来获取锁，有多个线程在等待一个锁，当这个锁被释放时，等待时间最久的线程（最先请求的线程）会获得该所，这种就是公平锁。
java中的synchronized是非公平锁
ReentrantLock和ReentrantReadWriteLock，它默认情况下是非公平锁，但是可以设置为公平锁。
#### 读写锁
即对文件的访问形式，一个读锁，一个写锁。
可以看 lockTest中TestReentrantReadWriteLock.java 详细了解

