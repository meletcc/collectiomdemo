package com.cjs.thread.threaddemo02.thread;

import java.io.IOException;

public class Demo2_Runtime {

    public static void main(String[] args) throws IOException {
        Runtime r = Runtime.getRuntime();//获取运行时对象，单例
        //r.exec("shutdown -s -t 300"); 这个方法是执行一个字符串命令，5分钟后关机
        r.exec("shutdown -a");
    }

}