package com.cjs.collection.collectiomdemo.mylinkedlist;

/**
 * 自定义一个链表
 * 包含第一个元素和最后一个元素、还有链表大小
 *
 * @author 陈峻松
 * @date 2019/4/15
 */
public class CjsLinkedList01 {

    private Node first;
    private Node last;
    private int size;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node temp = first;

        while (temp != null) {
            sb.append(temp.getElement() + ",");
            temp = temp.getNext();
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    /**
     * 从第一个手拉手给链表中添加元素
     * [] -> [a,b] -> [a,b,c]
     *
     * @param object 要添加的元素内容
     */
    public void add(Object object) {
        Node node = new Node(object);
        // 第一次放内容，node结点的前后结点都为空，默认初始了已经
        if (first == null) {
            first = node;
            last = node;
        } else {
            node.setPrevious(last);
            node.setNext(null);
            last.setNext(node);
            last = node;
        }
        size++;
    }

    /**
     * 获取链表长度
     *
     * @return 长度
     */
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        CjsLinkedList01 cjsLinkedList01 = new CjsLinkedList01();
        cjsLinkedList01.add("a");
        cjsLinkedList01.add("b");
        cjsLinkedList01.add("c");
        System.out.println(cjsLinkedList01);
    }
}
