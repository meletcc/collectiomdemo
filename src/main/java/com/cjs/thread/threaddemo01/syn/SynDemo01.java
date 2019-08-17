package com.cjs.thread.threaddemo01.syn;

/**
 * 线程不安全：有负数、有相同的
 */
public class SynDemo01 {

    public static void main(String[] args) {
        // 真实角色
        Web12306 web = new Web12306();
        // 代理
        Thread t1 = new Thread(web, "路人甲");
        Thread t2 = new Thread(web, "黄牛已");
        Thread t3 = new Thread(web, "攻城师");
        //启动线程
        t1.start();
        t2.start();
        t3.start();
    }
}

class Web12306 implements Runnable {

    private int num = 10;
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            test5();
        }
    }

    public void test6() {
        if (num <= 0) {
            flag = false;
            return;
        }
        //a  b  c
        synchronized (this) {
            try {
                Thread.sleep(500); //ģ�� ��ʱ
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "������" + num--);
        }
    }

    public void test5() {
        synchronized ((Integer) num) {
            if (num <= 0) {
                flag = false;
                return;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "������" + num--);
        }
    }

    public void test4() {
        //   c  1
        synchronized (this) {
            //b
            if (num <= 0) {
                flag = false; //����ѭ��
                return;
            }
        }
        // b
        try {
            Thread.sleep(500); //ģ�� ��ʱ
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "������" + num--);
    }//a -->1


    //
    public void test3() {
        //a  b  c
        synchronized (this) {
            if (num <= 0) {
                flag = false; //����ѭ��
                return;
            }
            try {
                Thread.sleep(500); //ģ�� ��ʱ
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "������" + num--);
        }
    }

    //
    public synchronized void test2() {
        if (num <= 0) {
            flag = false; //����ѭ��
            return;
        }
        try {
            Thread.sleep(500); //ģ�� ��ʱ
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "������" + num--);
    }


    //
    public void test1() {
        if (num <= 0) {
            flag = false; //����ѭ��
            return;
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "������" + num--);
    }
}
