package com.cjs.collection.collectiomdemo.mylinkedlist;

/**
 * 自定义一个链表
 * 包含第一个元素和最后一个元素、还有链表大小
 * 第三个版本：增加remove方法
 *
 * @author 陈峻松
 * @date 2019/6/1
 */
public class CjsLinkedList03 {

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
     * 根据索引获取元素
     * 从第一个节点开始找，找到index为止，效率不高。可以采用二分法，往前或往后找
     *
     * @param index 索引
     * @return 该节点元素
     */
    public Object get(int index) {
        if (index < 0 || index > size - 1) {
            throw new RuntimeException("索引范围不合法" + index);
        }
        return getNode(index) != null ? getNode(index).getElement() : null;
    }

    /**
     * 根据索引返回Node结点
     *
     * @param index 索引
     * @return 结点
     */
    public Node getNode(int index) {
        Node temp = null;
        if (index <= (size >> 1)) {// 相当于除以2
            temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
        } else {
            temp = last;
            for (int i = size - 1; i > index; i--) {
                temp = temp.getPrevious();
            }
        }
        return temp;
    }

    /**
     * remove方法
     */
    public void remove(int index) {
        Node removeNode = getNode(index);
        if (removeNode != null) {
            Node previous = removeNode.getPrevious();
            Node next = removeNode.getNext();

        }

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
        CjsLinkedList03 cjsLinkedList03 = new CjsLinkedList03();
        cjsLinkedList03.add("a");
        cjsLinkedList03.add("b");
        cjsLinkedList03.add("c");
        cjsLinkedList03.add("d");
        cjsLinkedList03.add("f");
        System.out.println(cjsLinkedList03);

        Object o = cjsLinkedList03.get(4);
        System.out.println(cjsLinkedList03.size());
        System.out.println(o);
    }
}
