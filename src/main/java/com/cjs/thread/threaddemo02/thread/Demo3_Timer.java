package com.cjs.thread.threaddemo02.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Demo3_Timer {

    public static void main(String[] args) throws InterruptedException {
        Timer t = new Timer();
        //定时器对象：在指定时间安排指定任务
        //第一个参数是安排的任务,第二个参数是什么时间执行,第三个参数是过多长时间再重复执行
        //注意 Date 的年是与1900年的差值；月是从0-11
        t.schedule(new MyTimerTask(), new Date(188, 6, 1, 14, 22, 50), 3000);
        while (true) {
            Thread.sleep(1000);
            System.out.println(new Date());
        }
    }
}

class MyTimerTask extends TimerTask {
    // TimerTask 类中的run方法是一个抽象方法，需要实现类具体实现
    @Override
    public void run() {
        System.out.println("起床背英语单词");
    }
}
