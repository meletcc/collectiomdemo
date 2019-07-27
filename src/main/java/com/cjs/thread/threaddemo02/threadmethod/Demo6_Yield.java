package com.cjs.thread.threaddemo02.threadmethod;

public class Demo6_Yield {

    /**
     * yield让出cpu礼让线程
     * 让当前正在执行的线程暂停，从运行状态转入就绪状态
     * 让cup重新调度
     */
    public static void main(String[] args) {
        new MyThread().start();
        new MyThread().start();
    }

}

class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            if (i % 10 == 0) {
                Thread.yield();                        //让出CPU
            }
            System.out.println(getName() + "..." + i);
        }
    }
}