package com.cjs.collection.collectiomdemo.myhashmap;

/**
 * 自定义HashMap的Node对象
 *
 * @author 陈峻松
 * @date 2019/7/6
 */
public class Node2 {

    private int hash;
    private Object k;
    private Object v;
    private Node2 next;

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public Object getK() {
        return k;
    }

    public void setK(Object k) {
        this.k = k;
    }

    public Object getV() {
        return v;
    }

    public void setV(Object v) {
        this.v = v;
    }

    public Node2 getNext() {
        return next;
    }

    public void setNext(Node2 next) {
        this.next = next;
    }
}
