package com.cjs.collection.collectiomdemo.map;

import java.util.*;

/**
 * 测试迭代器遍历List、Set、Map
 *
 * @author 陈峻松
 * @date 2019/7/8
 */
public class TestIterator {

    public static void main(String[] args) {
//        testList();
//        testSet();
//        testMap01();
        testMap02();
    }

    public static void testList() {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        // 迭代器中的hasNext()、next()、remove()三个方法
        for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
            String next = iterator.next();
            System.out.println(next);
        }
    }

    public static void testSet() {
        Set<String> set = new HashSet<>();
        set.add("aa");
        set.add("bb");
        set.add("cc");
        for (Iterator<String> iterator = set.iterator(); iterator.hasNext(); ) {
            String next = iterator.next();
            System.out.println(next);
        }
    }

    // 测试map的第一种方式
    public static void testMap01() {
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "a");
        map1.put(2, "b");
        map1.put(3, "c");
        Set<Map.Entry<Integer, String>> entrySet = map1.entrySet();
        // 拿到entrySet之后，和遍历set一样
        for (Iterator<Map.Entry<Integer, String>> iterator = entrySet.iterator(); iterator.hasNext(); ) {
            Map.Entry<Integer, String> next = iterator.next();
            System.out.println(next.getKey() + "---" + next.getValue());
        }
    }

    public static void testMap02() {
        Map<Integer, String> map2 = new HashMap<>();
        map2.put(4, "d");
        map2.put(5, "e");
        map2.put(6, "f");
        Set<Integer> keySet = map2.keySet();
        for (Iterator<Integer> iterator = keySet.iterator(); iterator.hasNext(); ) {
            Integer key = iterator.next();
            System.out.println(key + "--" + map2.get(key));
        }
    }

}
