package com.cjs.collection.collectiomdemo.myhashmap;

import java.util.HashMap;

/**
 * 自定义的HashSet，深刻理解底层原理
 *
 * @author 陈峻松
 * @date 2019/7/7
 */
public class MyHashSet<E> {

    private HashMap<E, Object> map;
    private static final Object PRESENT = new Object();

    public MyHashSet() {
        map = new HashMap();
    }

    public int size() {
        return map.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Object o : map.keySet()) {
            sb.append(o + ",");
        }
        sb.setCharAt(sb.length() - 1, '}');
        return sb.toString();
    }

    /**
     * 从这个方法可以看出：set只操作HashMap中的key，所以唯一，不重复
     * 值对象就是一个固定的对象
     *
     * @param e 需要添加的元素
     */
    public void add(E e) {
        map.put(e, PRESENT);
    }

    public static void main(String[] args) {
        MyHashSet<String> myHashSet = new MyHashSet<>();
        myHashSet.add("aa");
        myHashSet.add("bb");
        myHashSet.add("cc");
        System.out.println(myHashSet);
    }

}
