package com.cjs.collection.collectiomdemo.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 测试工具类Collections。java.util.Collections
 * 提供了对Set、List、Map进行排序、填充、查找元素的辅助方法
 * collection是接口
 *
 * @author 陈峻松
 * @date 2019/7/8
 */
public class TestCollections {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("c" + i);
        }
        System.out.println(list);
        Collections.shuffle(list);// 随机排列list中元素
        System.out.println(list);
        Collections.reverse(list);// 逆序排序
        System.out.println(list);
        Collections.sort(list);// 按照递增的方式排序（数字递增、字母按照abc、自定义类：Comparable接口）
        System.out.println(list);
        System.out.println(Collections.binarySearch(list, "c0"));// 二分查找、折半查找

    }

}
