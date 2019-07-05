package com.cjs.collection.collectiomdemo.myhashmap;

/**
 * 自定义的HashMap
 *
 * @author 陈峻松
 * @date 2019/7/6
 */
public class MyHashMap01 {

    // 核心的位桶数组，bucket array
    private Node2[] table;

    // 存放的键值对个数
    private int size;

    public MyHashMap01() {
        table = new Node2[16];// 长度一般为2的整数幂
    }

    /**
     * put方法
     *
     * @param k 键对象
     * @param v 值对象
     */
    public void put(Object k, Object v) {
        // 定义了新的结点对象
        Node2 node = new Node2();
        node.setHash(myHash(k.hashCode(), table.length));
        node.setK(k);
        node.setV(v);
        node.setNext(null);
        // 根据算出的hash值，放入位桶数组的某个位置，将hash值和数组关联
        Node2 temp = table[node.getHash()];

        if (temp == null) {
            // 此哈希值处数组元素为空，直接将结点放入
            table[node.getHash()] = node;
        } else {
            // 此处数组元素不为空，遍历对应链表，再判断key值是否重复，该覆盖还是追加
        }

    }

    /**
     * 自定义的hash算法
     *
     * @param v    哈希码
     * @param size 数组长度
     * @return 哈希值
     */
    private int myHash(int v, int size) {
        System.out.println(v % size);// 取模运算，效率低
        System.out.println(v & (size - 1));// 直接位运算，效率高
        return v & (size - 1);
    }

    public static void main(String[] args) {
        MyHashMap01 myHashMap01 = new MyHashMap01();
        myHashMap01.put(10, "aa");
        myHashMap01.put(20, "bb");
        myHashMap01.put(30, "cc");
    }

}
