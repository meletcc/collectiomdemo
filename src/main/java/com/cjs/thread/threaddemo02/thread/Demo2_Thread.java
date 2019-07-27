package com.cjs.thread.threaddemo02.thread;

/**
 * 第一种方式：继承 Thread 类，实现 run 方法。start()方法执行时候，自动调用 run 方法
 */
public class Demo2_Thread {

    public static void main(String[] args) {
        MyThread mt = new MyThread();        //4,创建Thread类的子类对象
        mt.start();                            //5,开启线程

        for (int i = 0; i < 1000; i++) {        //6,主线程
            System.out.println("bb");
        }
    }
}

class MyThread extends Thread {                //1,继承Thread
    public void run() {                        //2,重写run方法
        for (int i = 0; i < 1000; i++) {        //3,将要执行的代码写在run方法中
            System.out.println("aaaaaaaaaaaa");
        }
    }
}