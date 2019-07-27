package com.cjs.thread.threaddemo01.create;

public class RabbitApp {
    /**
     * 主线程，一启动就有了，所以讲究线程开启时机，之前开启
     */
    public static void main(String[] args) {
        // 启动线程：1.创建子类对象
        Rabbit rab = new Rabbit();
        Tortoise tor = new Tortoise();

        // 2.调用start方法开始一个线程，不保证立即运行，由cpu调用
        // 不要调用run方法，run方法只是普通方法调用
        // 这里start交给cpu，不是自己控制
        rab.run();
        //tor.start();
        tor.run();

        for (int i = 0; i < 100; i++) {
            System.out.println("main==>" + i);
        }
    }

}
