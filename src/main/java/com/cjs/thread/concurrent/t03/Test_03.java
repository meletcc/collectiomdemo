/**
 * 可打断
 * <p>
 * 阻塞状态： 包括普通阻塞，等待队列，锁池队列。
 * 普通阻塞： sleep(10000)， 可以被打断。调用thread.interrupt()方法，可以打断阻塞状态，抛出异常。
 * 等待队列： wait()方法被调用，也是一种阻塞状态，只能由notify唤醒。无法打断
 * 锁池队列： 无法获取锁标记。不是所有的锁池队列都可被打断。
 * 使用ReentrantLock的lock方法，获取锁标记的时候，如果需要阻塞等待锁标记，无法被打断。
 * 使用ReentrantLock的lockInterruptibly方法，获取锁标记的时候，如果需要阻塞等待，可以被打断。
 */
package com.cjs.thread.concurrent.t03;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test_03 {
    Lock lock = new ReentrantLock();


    // A线程运行m1，B线程运行m2，都需要lock对象的锁标记，但是lock标记被A线程持有。B进入阻塞状态
    // 一般来说B需要A线程执行完释放这个锁标记，才重新进入就绪状态，等到cup的时间片后，再次判断这个锁标记。

    void m1() {
        try {
            lock.lock();
            for (int i = 0; i < 5; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("m1() method " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void m2() {
        try {
            lock.lockInterruptibly(); // 可尝试打断，阻塞等待锁。可以被其他的线程打断阻塞状态-interrupt()
            System.out.println("m2() method");
        } catch (InterruptedException e) {
            System.out.println("m2() method interrupted");
        } finally {
            try {
                lock.unlock();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final Test_03 t = new Test_03();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t.m1();
            }
        }).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                t.m2();
            }
        });
        t2.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        t2.interrupt();// 打断线程休眠。非正常结束阻塞状态的线程，都会抛出异常。只能打断阻塞状态的线程
    }
}
