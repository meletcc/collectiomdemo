package com.cjs.collection.collectiomdemo.mylinkedlist;

/**
 * 自定义一个链表
 * 包含第一个元素和最后一个元素、还有链表大小
 * 第五个版本：小封装，增加泛型
 *
 * @author 陈峻松
 * @date 2019/6/1
 */
public class CjsLinkedList05<E> {

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
     * @param element 要添加的元素内容
     */
    public void add(E element) {
        Node node = new Node(element);
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
     * 在指定索引位置插入结点
     *
     * @param index   需要插入的位置
     * @param element 插入的内容
     */
    public void add(int index, E element) {
        checkIndex(index);
        // 需要考虑的事情：结点判空；首末结点处理
        Node newNode = new Node(element);
        Node temp = getNode(index);
        if (temp != null) {
            Node up = temp.getPrevious();
            up.setNext(newNode);
            newNode.setPrevious(up);
            newNode.setNext(temp);
            temp.setPrevious(newNode);
            size++;
        }
    }

    /**
     * 根据索引获取元素
     * 从第一个节点开始找，找到index为止，效率不高。可以采用二分法，往前或往后找
     *
     * @param index 索引
     * @return 该节点元素
     */
    public E get(int index) {
        checkIndex(index);
        return getNode(index) != null ? (E) getNode(index).getElement() : null;
    }

    /**
     * 检查索引范围
     *
     * @param index 索引
     */
    private void checkIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new RuntimeException("索引范围不合法" + index);
        }
    }

    /**
     * 根据索引返回Node结点
     * 链表查找效率很低，增删效率高
     *
     * @param index 索引
     * @return 结点
     */
    private Node getNode(int index) {
        checkIndex(index);
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
        checkIndex(index);
        Node removeNode = getNode(index);
        if (removeNode != null) {
            Node previous = removeNode.getPrevious();
            Node next = removeNode.getNext();
            if (previous != null) {
                previous.setNext(next);
            }
            if (next != null) {
                next.setPrevious(previous);
            }
            // 被删除的元素是第一个元素时
            if (index == 0) {
                first = next;
            }
            // 被删除的元素是最后一个元素时
            if (index == size - 1) {
                last = previous;
            }
            size--;
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
        CjsLinkedList05<String> cjsLinkedList05 = new CjsLinkedList05<>();
        cjsLinkedList05.add("a");
        cjsLinkedList05.add("b");
        cjsLinkedList05.add("c");
        cjsLinkedList05.add("d");
        cjsLinkedList05.add("f");
        System.out.println(cjsLinkedList05);

        Object o = cjsLinkedList05.get(4);
        System.out.println(cjsLinkedList05.size());
        System.out.println(o);
        cjsLinkedList05.remove(0);
        System.out.println(cjsLinkedList05);
        System.out.println(cjsLinkedList05.size());
    }
}
