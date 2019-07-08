package com.cjs.collection.collectiomdemo.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 表格数据的存储02
 * ORM思想：对象关系映射（熟悉数据库编程）
 * 每一行数据使用一个javabean对象，多行（整个表格）使用一个map\list
 *
 * @author 陈峻松
 * @date 2019/7/8
 */
public class TestStoreData02 {

    public static void main(String[] args) {
        User user1 = new User(1001, "张三", 5000, "2018-10-5");
        User user2 = new User(1002, "李四", 5500, "2017-9-15");
        User user3 = new User(1003, "王五", 3500, "2018-12-20");

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        for (User user : list) {
            System.out.println(user);
        }

        Map<Integer, User> map = new HashMap<>();
        map.put(1001, user1);
        map.put(1002, user2);
        map.put(1003, user3);
        for (Integer keyset : map.keySet()) {
            System.out.println(keyset + "---" + map.get(keyset));
        }
    }

}

/**
 * 一个完整的javabean对象要有get、set、一个无参构造
 */
class User {
    private int id;
    private String name;
    private double salary;
    private String date;

    public User() {
    }

    public User(int id, String name, double salary, String date) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", date='" + date + '\'' +
                '}';
    }
}
