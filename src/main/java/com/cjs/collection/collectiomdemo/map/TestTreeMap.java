package com.cjs.collection.collectiomdemo.map;

import java.util.Map;
import java.util.TreeMap;

/**
 * 1.TreeMap的使用，主要用于key或者value需要排序时候
 * 2.Comparable接口的使用
 * 3.HashTable与HashMap的区别：HashMap线程不安全，效率高，允许key或value为null，实现Map接口
 * HashTable线程安全，效率低，不允许key和value为null，继承Dictionary类
 * 其他都一样
 */
public class TestTreeMap {

    public static void main(String[] args) {
        Map<Integer, String> map = new TreeMap<>();
        map.put(20, "aa");
        map.put(3, "bb");
        map.put(6, "cc");
        map.put(12, "ssss");

        // keySet()返回key的Set集合
        for (Integer key : map.keySet()) {
            // 按照key递增的方式排序（限于数字，要是自定义key对象如何排序：实现Comparable接口）
            System.out.println(key + " : " + map.get(key));
        }

        TreeMap<Emp, String> map2 = new TreeMap<>();
        map2.put(new Emp(100, "张三", 5000), "aa");
        map2.put(new Emp(200, "李四", 300), "bbc");
        map2.put(new Emp(300, "王五", 9000), "ddc");
        map2.put(new Emp(300, "王五", 20), "ddc");
        map2.put(new Emp(100, "王五", 300), "ddc");
        for (Emp emp : map2.keySet()) {
            // 按照key递增的方式排序（限于数字，要是自定义key对象如何排序：实现Comparable接口）
            System.out.println(emp + " : " + map2.get(emp));
        }
    }
}

class Emp implements Comparable<Emp> {
    private int id;
    private String name;
    private double slary;

    public Emp(int id, String name, double slary) {
        this.id = id;
        this.name = name;
        this.slary = slary;
    }

    @Override
    public String toString() {
        return "id:" + id + ", name：" + name + ", slary" + slary;
    }

    @Override
    public int compareTo(Emp o) {// 负数：小于，0：正数，：大于
        if (this.slary > o.slary) {
            return 1;
        } else if (this.slary < o.slary) {
            return -1;
        } else if (this.id > o.id) {
            return 1;
        } else if (this.id < o.id) {
            return -1;
        } else {
            return 0;
        }

    }
}
