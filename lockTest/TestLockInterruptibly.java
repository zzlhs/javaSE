package cn.zzl.lockTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLockInterruptibly {
	private Lock lock = new ReentrantLock();
	public static void main(String[] args) {
		TestLockInterruptibly test = new TestLockInterruptibly();
		
		MyThread t1 = new MyThread(test);
		MyThread t2 = new MyThread(test);
		
		t1.start();
		t2.start();
		
		try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.interrupt();

	}

	
	public void insert(Thread thread) throws InterruptedException {
		lock.lockInterruptibly();
		try {
			System.out.println(thread.getName()+"得到了锁");
			long startTime = System.currentTimeMillis();
			for(;;) {
				if(System.currentTimeMillis() - startTime >= Integer.MAX_VALUE)
					break;
			}
		}finally {
			System.out.println(Thread.currentThread().getName()+"执行finally");
			lock.unlock();
			System.out.println(thread.getName()+"释放了锁");
		}
	}
}

class MyThread extends Thread {
    private TestLockInterruptibly test = null;
    public MyThread(TestLockInterruptibly test) {
        this.test = test;
    }
    @Override
    public void run() {
         
        try {
            test.insert(Thread.currentThread());
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+"被中断");
        }
    }
}
