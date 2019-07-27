package com.cjs.thread.threaddemo01.create;

/**
 * 使用lambda表达式简化线程（用一次、简单）使用
 * 1.外部类实现
 * 2.静态内部类
 * 3.局部内部类
 * 4.lambda表达式（保证接口只有一个方法才能使用）
 * lambda推导必须存在类型
 * 避免匿名内部类定义过多，函数式编程
 * (params) -> 表达式
 * (params) -> 语句
 * (params) -> {语句块}
 */
public class LambdaThread {

    /**
     * 静态内部类：一个类只用一次提升性能
     * 随着外部类的使用进行加载，外部类不使用不会加载，不使用不会编译
     */
    static class Test1 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println("一边敲helloworld" + i);
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Test1()).start();

        /**
         * 简化:局部内部类：写在方法里的类
         */
        class Test2 implements Runnable {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("一边敲helloworld" + i);
                }
            }
        }
        new Thread(new Test2()).start();

        // 再简化使用匿名内部类：必须借助接口或者父类
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("一边敲helloworld" + i);
                }
            }
        }).start();

        /**
         * jdk8再进行简化：lambda表达式
         * 只关注参数、和实现体
         */
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("一边敲helloworld" + i);
            }
        }).start();
    }
}