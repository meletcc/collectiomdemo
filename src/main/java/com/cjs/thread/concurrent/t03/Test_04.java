/**
 * 并发量大于10。一般不用公平锁，消耗cup计算时间去计算等待时间
 * 公平锁：等待时间越长，一定会先获得锁标记，执行，会记录等待时长
 * os底层考虑效率问题，所以cup是不公平的，不会考虑多个线程谁等待的时间长短，竞争机制，谁抢到谁执行
 * 让多个竞争锁标记的线程公平交替执行
 */
package com.cjs.thread.concurrent.t03;

import java.util.concurrent.locks.ReentrantLock;

public class Test_04 {

    public static void main(String[] args) {
        TestReentrantlock t = new TestReentrantlock();
        //TestSync t = new TestSync();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.start();
        t2.start();
    }
}

class TestReentrantlock extends Thread {
    // 参数true定义一个公平锁，不加参数则普通锁
    private static ReentrantLock lock = new ReentrantLock(true);

    public void run() {
        for (int i = 0; i < 5; i++) {
            // lock方法，获取锁标记
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " get lock");
            } finally {
                lock.unlock();
            }
        }
    }

}

class TestSync extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {

            // 同步代码块是非公平的机制，竞争锁
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + " get lock in TestSync");
            }
        }
    }
}
