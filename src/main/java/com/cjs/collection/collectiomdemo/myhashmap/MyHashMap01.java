package com.cjs.collection.collectiomdemo.myhashmap;

/**
 * 自定义的HashMap
 * 实现了put方法增加键值对，并解决了键重复时覆盖相应的节点，同时解决相同hash值在同一链表追加的问题
 *
 * @author 陈峻松
 * @date 2019/7/6
 */
public class MyHashMap01 {

    // 核心位桶数组，bucket array
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
        // 新的结点对象（数组中存的是结点）
        Node2 node = new Node2();
        node.setHash(myHash(k.hashCode(), table.length));
        node.setK(k);
        node.setV(v);
        node.setNext(null);

        // 将hash值和数组关联：根据算出的hash值，放入位桶数组的特定位置
        Node2 temp = table[node.getHash()];
        // 标识：正在遍历的最后一个元素
        Node2 lastNode = null;
        // 标识：key是否重复
        boolean keyRepeat = false;

        if (temp == null) {
            // 此哈希值处数组元素为空，直接将结点放入
            table[node.getHash()] = node;
            size++;
        } else {
            // 此处数组元素不为空，遍历对应链表，再判断key值是否重复，该覆盖还是追加
            while (temp != null) {
                // 如果key重复，则覆盖
                if (temp.getK().equals(k)) {
                    keyRepeat = true;
                    // 只是覆盖value即可，其他的值保持不变（hash、key、next）
                    temp.setV(v);
                    break;
                } else {
                    // key不重复，遍历下一个元素
                    lastNode = temp;
                    temp = temp.getNext();
                }
            }
            // 遍历结束，最后一个元素的下一个放入该节点
            if (!keyRepeat) {
                lastNode.setNext(node);
                size++;
            }
        }
    }

    /**
     * 自定义的hash算法（散列算法）
     *
     * @param v      键对象的哈希码
     * @param length 数组长度
     * @return 哈希值
     */
    private int myHash(int v, int length) {
        System.out.println(v & (length - 1));// 直接位运算，效率高
        System.out.println(v % length);// 取模运算，效率低
        return v & (length - 1);
    }

    public static void main(String[] args) {
        MyHashMap01 myHashMap01 = new MyHashMap01();
        myHashMap01.put(10, "aa");
        myHashMap01.put(20, "bb");
        myHashMap01.put(30, "cc");
        myHashMap01.put(30, "eeee");
        System.out.println(myHashMap01);
    }

}
