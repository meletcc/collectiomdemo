package com.cjs.collection.collectiomdemo.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 测试Map的常用方法
 * Map键值成对存储，键值都可以是任何对象
 * Map接口的实现类：HashMap、TreeMap、HashTable、Properties等
 * HashMap底层实现采用了哈希表（很重要的数据结构）
 * 打开源码看HashMap的结构-核心为：位桶数组（结点数组Entry[]\Node[]）
 * 哈希表的基本结构就是：“数组+链表”，结合了两者的优点
 *
 * @author 陈峻松
 * @date 2019/7/4
 */
public class TestMap {

    public static void main(String[] args) {
        Map<Integer, String> m1 = new HashMap<>();
        m1.put(1, "one");
        m1.put(2, "two");
        m1.put(3, "three");

        Set<Map.Entry<Integer, String>> entries = m1.entrySet();
        Set<Integer> integers = m1.keySet();
        String remove = m1.remove(1);
        boolean one = m1.remove(1, "one");

        System.out.println(m1.get(1));
        System.out.println(m1.containsKey(2));
        System.out.println(m1.containsValue("one"));
        System.out.println(m1.isEmpty());
        System.out.println(m1.size());
        m1.clear();

        Map<Integer, String> m2 = new HashMap<>();
        m2.put(4, "四");
        m2.put(5, "五");
        m1.putAll(m2);
        System.out.println(m1);

        // map中的键不能重复！如果重复（是否重复根据equals方法判断），新的值会覆盖旧的
        m1.put(3, "三");
        System.out.println(m1);

        Map<Integer, Employee> m3 = new HashMap<>();
        Employee e1 = new Employee(1001, "小陈", 9000);
        Employee e2 = new Employee(1002, "小李", 6000);
        Employee e3 = new Employee(1003, "小白", 7000);
        m3.put(1001, e1);
        m3.put(1002, e2);
        m3.put(1003, e3);
        System.out.println(m3.get(1001).getName());
        System.out.println(m3);

    }

}

class Employee {
    private int num;
    private String name;
    private double salary;

    public Employee(int num, String name, double salary) {
        this.num = num;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "id" + num + "name" + name + "薪水" + salary;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
