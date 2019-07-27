package com.cjs.thread.threaddemo01.create;

public class ProgrammerApp {

    public static void main(String[] args) {
        //1)、创建真实实现类对象
        Programmer pro = new Programmer();
        //2)、创建代理对象 +真实角色引用
        Thread proxy = new Thread(pro);
        //3)、调用 .start() 启动线程
        proxy.start();

        // 如果一个对象只使用一次，可以使用匿名对象
//        new Thread(new Programmer()).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("一边聊qq...." + i);
        }
    }

}
