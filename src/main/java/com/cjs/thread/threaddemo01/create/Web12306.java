package com.cjs.thread.threaddemo01.create;

/**
 * 实现接口方式比继承的好处：方便共享资源
 * 多个代理会产生并发（需要保证线程安全）
 */
public class Web12306 implements Runnable {
    // 票数
    private int num = 50;

    @Override
    public void run() {
        while (true) {
            if (num <= 0) {
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "抢到了" + num--);
        }
    }

    public static void main(String[] args) {
        //真实角色，一份资源
        Web12306 web = new Web12306();
        System.out.println(Thread.currentThread().getName());
        //多个代理
        Thread t1 = new Thread(web, "路人甲");
        Thread t2 = new Thread(web, "黄牛已");
        Thread t3 = new Thread(web, "攻城师");
        //启动线程
        t1.start();
        t2.start();
        t3.start();
    }
}
