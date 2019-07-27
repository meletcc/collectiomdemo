package com.cjs.thread.threaddemo02.thread2;

public class Demo1_Notify {
    /**
     * 等待唤醒机制：wait() 、 notify()；
     */
    public static void main(String[] args) {

        // 局部内部类使用局部变量时候，必须加 final
        final Printer p = new Printer();

        new Thread() {
            public void run() {
                while (true) {
                    try {
                        p.print1();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread() {
            public void run() {
                while (true) {
                    try {
                        p.print2();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

}

//等待唤醒机制：两个线程的通讯，一个叫一个，一个完成了叫醒另一个
class Printer {

    private int flag = 1;

    public void print1() throws InterruptedException {
        synchronized (this) {                    //同步代码块（当前对象的锁对象）
            if (flag != 1) {
                this.wait();                    //当前线程等待，cup执行权让出，让其他线程执行
            }
            System.out.print("黑");
            System.out.print("马");
            System.out.print("程");
            System.out.print("序");
            System.out.print("员");
            System.out.print("\r\n");
            flag = 2;
            this.notify();                        //随机唤醒单个等待的线程
        }
    }

    public void print2() throws InterruptedException {
        synchronized (this) {
            if (flag != 2) {
                this.wait();
            }
            System.out.print("传");
            System.out.print("智");
            System.out.print("播");
            System.out.print("客");
            System.out.print("\r\n");
            flag = 1;
            this.notify();
        }
    }
}

