package com.cjs.thread.threaddemo02.thread;

public class Demo1_Thread {
    /**
     * 证明jvm是多线程的
     */
    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            // 这是另外一条垃圾回收的线程，与主线程代码交替执行，不断的new对象，先前的就变成垃圾
            new Demo();
        }
        for (int i = 0; i < 10000; i++) {
            System.out.println("我是主线程的执行代码");
        }
    }
}

class Demo {
    // Object 类的方法，在垃圾回收的时候调用此方法
    @Override
    public void finalize() {
        System.out.println("垃圾被清扫了");
    }
}