package com.cjs.thread.threaddemo02.thread2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo5_Executors {

    /**
     * public static ExecutorService newFixedThreadPool(int nThreads)
     * public static ExecutorService newSingleThreadExecutor()
     * 池子都是list等集合类
     * 因为要一直保持住这些数据，所以list这些集合类，又要一直保存在内存中，所以很消耗资源的，并且得是静态的来保证常驻内存
     */
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);//创建线程池
        pool.submit(new MyRunnable());                //将线程放进池子里并执行
        pool.submit(new MyRunnable());

        pool.shutdown();                            //关闭线程池
    }

}

