/**
 * synchronized关键字
 * 锁对象。synchronized(this)和synchronized方法（同步方法）都是锁当前对象。
 */
package com.cjs.thread.concurrent.t01;

import java.util.concurrent.TimeUnit;

public class Test_01 {
    private int count = 0;
    private Object o = new Object();

    public void testSync1() {
        // 临界资源对象
        synchronized (o) {
            System.out.println(Thread.currentThread().getName()
                    + " count = " + count++);
        }
    }

    public void testSync2() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName()
                    + " count = " + count++);
        }
    }

    public synchronized void testSync3() {
        System.out.println(Thread.currentThread().getName()
                + " count = " + count++);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 同一个资源对象-this
        final Test_01 t = new Test_01();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t.testSync3();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t.testSync3();
            }
        }).start();
    }

}