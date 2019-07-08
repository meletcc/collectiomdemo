package com.cjs.collection.collectiomdemo.map;

import java.util.*;

/**
 * 表格数据的存储01
 * ORM思想：对象关系映射（熟悉数据库编程）
 * map表示一行数据，多行数据是多个map，将多个map（整个表格）放入list中
 *
 * @author 陈峻松
 * @date 2019/7/8
 */
public class TestStoreData01 {

    public static void main(String[] args) {
        Map<String, Object> row1 = new HashMap<>();
        row1.put("id", 1001);
        row1.put("姓名", "张三");
        row1.put("薪水", 5000);
        row1.put("入职日期", "2018.10.5");

        Map<String, Object> row2 = new HashMap<>();
        row2.put("id", 1002);
        row2.put("姓名", "李四");
        row2.put("薪水", 4500);
        row2.put("入职日期", "2018.9.5");

        Map<String, Object> row3 = new HashMap<>();
        row3.put("id", 1003);
        row3.put("姓名", "王五");
        row3.put("薪水", 6700);
        row3.put("入职日期", "2018.12.8");

        List<Map<String, Object>> list = new ArrayList<>();
        list.add(row1);
        list.add(row2);
        list.add(row3);

        for (Map<String, Object> map : list) {
            Set<String> set = map.keySet();
            for (String key : set) {
                System.out.print(key + ":" + map.get(key) + " ");
            }
            System.out.println();
        }
    }
}
