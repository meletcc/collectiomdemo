package com.cjs.thread.threaddemo02.threadmethod;

public class Demo4_Daemon {

    /**
     * 守护线程
     * 线程分为用户线程、守护线程
     * 守护线程为用户线程服务，jvm确保用户线程执行完毕，不用等待守护线程执行完毕
     * 默认是用户线程，jvm等待所有的用户线程执行完毕才会停止，不用考虑守护线程
     *
     */
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < 2; i++) {
                    System.out.println(getName() + "...aaaaaaaaaaaaaaaaaaaa");
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                for (int i = 0; i < 50; i++) {
                    System.out.println(getName() + "...bb");
                }
            }
        };

        t2.setDaemon(true);                            //设置为守护线程

        t1.start();
        t2.start();
    }

}
