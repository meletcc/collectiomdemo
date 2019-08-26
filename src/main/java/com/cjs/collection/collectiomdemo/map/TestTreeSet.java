package com.cjs.collection.collectiomdemo.map;

import java.util.TreeSet;

/**
 * 测试TreeSet的使用和底层原理，就是简化版本的TreeMap，只对key操作
 * TreeSet底层使用TreeMap实现的，通过key才存储set的元素
 * TreeSet需要对内部存储的元素进行排序，因此对应的类需要实现Comparable接口
 * 熟悉Comparable接口的使用
 */
public class TestTreeSet {

    public static void main(String[] args) {
        TreeSet<Emp> emps = new TreeSet<>();
        emps.add(new Emp(100, "张三", 500));
        emps.add(new Emp(10, "李四", 30));
        emps.add(new Emp(300, "王五", 600));
        emps.add(new Emp(20, "赵六", 4000));
        emps.add(new Emp(90, "qiqi", 30));
        // 按照元素递增的方式排好序（key排序）
        for (Emp emp : emps) {
            System.out.println(emp);
        }
    }

}
