package com.cjs.collection.collectiomdemo.myhashmap;

/**
 * 增加泛型后自定义HashMap的结点类
 *
 * @author 陈峻松
 * @date 2019/7/6
 */
public class Node3<K, V> {

    private int hash;
    private K k;
    private V v;
    private Node3 next;

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public K getK() {
        return k;
    }

    public void setK(K k) {
        this.k = k;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }

    public Node3 getNext() {
        return next;
    }

    public void setNext(Node3 next) {
        this.next = next;
    }
}
