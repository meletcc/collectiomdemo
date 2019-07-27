package com.cjs.thread.threaddemo01.create;

/**
 * 使用lambda表达式简化线程（用一次、简单）使用
 */
public class LambdaTest {
    public static void main(String[] args) {

        Sum s = new C();
        s.add(10, 20);

        s = (int a, int b) -> {
            System.out.println(a + b);
            return a + b;
        };
        s.add(20, 30);

        // 类型必须同时省略，一个参数括号可以省略
        s = (a, b) -> {
            System.out.println(a + b);
            return a + b;
        };
        s.add(30, 40);

        // 假设里面就一行代码，{}可以省略，return可以省略
//        s = (a, b) -> a + b;

        s = (a, b) -> 100;

    }
}

interface Sum {
    int add(int a, int b);
}

class C implements Sum {
    @Override
    public int add(int a, int b) {
        System.out.println(a + b);
        return a + b;
    }
}