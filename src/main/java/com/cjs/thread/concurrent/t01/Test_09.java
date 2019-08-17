/**
 * volatile关键字
 * volatile的内存可见性：多线程访问同一个变量，互相可见。
 * 通知OS操作系统底层，在CPU计算过程中，都要检查内存中数据的有效性。保证最新的内存数据被使用。
 * cup有很多计算核心，每个核心都可运行其中的线程
 * cup的高速缓存放当前计算时的临时数据，先把硬盘中的字节码文件加载到内存中，形成类对象和对象。
 * 在运行过程中，会把内存中的一些临时变量放在缓存中。
 * cup存在中断状态，可能会清空缓存，从内存中重新加载，刷新缓存空间
 * cup运行过程中不中断情况下一般只会从缓存中拿数据，但是加了volatile关键字，则需要随时从内存中检查该变量最新状态
 */
package com.cjs.thread.concurrent.t01;

import java.util.concurrent.TimeUnit;

public class Test_09 {

    volatile boolean b = true;

    void m() {
        System.out.println("start");
        while (b) {
        }
        System.out.println("end");
    }

    public static void main(String[] args) {
        final Test_09 t = new Test_09();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.b = false;
    }

}
