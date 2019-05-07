package com.cjs.collection.collectiomdemo.mylinkedlist;

/**
 * 结点或者entry对象
 *
 * @author 陈峻松
 * @date 2019/4/15
 */
public class Node {

    private Node previous;
    private Node next;
    private Object element;

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public Node(Object element) {
        this.element = element;
    }

    public Node(Node previous, Node next, Object element) {
        this.previous = previous;
        this.next = next;
        this.element = element;
    }
}
