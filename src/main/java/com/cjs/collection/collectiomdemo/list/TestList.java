package com.cjs.collection.collectiomdemo.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 测试 Collection接口中的方法
 * Collection的子接口 Set、List接口同样有这些方法，同时还有其他的方法
 * 需要看底层实现
 *
 * @author 陈峻松
 * @date 2019/4/12
 */
public class TestList {

    public static void main(String[] args) {
        testList();
    }

    /**
     * Collection接口中常用的方法
     */
    public static void testCollection01() {
        Collection<String> c = new ArrayList<>();
        c.add("老大");
        c.add("老二");
        System.out.println(c.contains("老三"));
        System.out.println(c.size());
        System.out.println(c.isEmpty());
        // 转化为Object数组
        Object[] objects = c.toArray();
        System.out.println(objects);
        // 注意，add和remove方法，操作的都是引用地址，对象本身还是存在， 只是remove了而已
        c.remove("老二");
        // 清空所有元素
        c.clear();
    }

    /**
     * Collection接口中涉及两个集合的操作
     */
    public static void testCollection02() {
        Collection<String> c1 = new ArrayList<>();
        c1.add("aa");
        c1.add("bb");
        c1.add("cc");
        Collection<String> c2 = new ArrayList<>();
        c2.add("aa");
        c2.add("dd");
        c2.add("ee");
        System.out.println("c1原始的:" + c1);

        // addAll()，把参数中的集合全部加入到前面的集合
//        c1.addAll(c2);
//        System.out.println("c1和c2操作后:" + c1);
        // removeAll()，把和c2中的相同的元素移除
//        c1.removeAll(c2);
//        System.out.println("c1和c2操作后:" + c1);
        // 找两个集合的交集
//        c1.retainAll(c2);
//        System.out.println("c1和c2操作后:" + c1);
        // 看是否c2全部包含于c1中
        boolean b = c1.containsAll(c2);
        System.out.println(b);
    }

    /**
     * 测试List接口中的常用方法
     */
    public static void testList() {
        List<String> list = new ArrayList<>();
        // add方法和add（index）方法的区别：add在后追加，后者加入指定下标位置
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);
        list.add(2, "cjs");
        System.out.println(list);

        list.remove(2);
        System.out.println(list);

        // 替换该下标元素
        list.set(2, "xixixi");
        System.out.println(list);

        list.add("d");
        list.add("b");
        list.add("e");

        // 返回第一次出现这个元素的位置，未找到返回-1
        int b = list.indexOf("b");
        System.out.println(b);

        // 返回最后一次出现该元素的位置，未找到返回-1
        int b1 = list.lastIndexOf("b");
        System.out.println(b1);

    }


}
