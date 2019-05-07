package com.cjs.collection.collectiomdemo.myarraylist;

/**
 * 自定义实现一个ArrayList，理解底层原理
 * 第三版本：增加数组扩容
 *
 * @author 陈峻松
 * @date 2019/4/12
 */
public class CjsArrayList03<E> {

    /**
     * 对象数组容器
     */
    private Object[] elementData;
    /**
     * 容器的大小
     */
    private int size;
    /**
     * 容器默认容量
     */
    private static final int DEFALT_CAPACITY = 10;

    /**
     * 默认容量的构造
     */
    public CjsArrayList03() {
        elementData = new Object[DEFALT_CAPACITY];
    }

    /**
     * 重载构造
     *
     * @param capacity 想要的容量
     */
    public CjsArrayList03(int capacity) {
        elementData = new Object[capacity];
    }

    /**
     * 重写toString方法，实现打印效果：[aa,bb]
     *
     * @return 字符串
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        // 这种循环会把后面null的元素打印出来
//        for (Object o : elementData) {
//            sb.append(o + ",");
//        }
        for (int i = 0; i < size; i++) {
            sb.append(elementData[i] + ",");
        }
//        sb.append("]");
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    /**
     * 往容器后依次追加元素，泛型只能传那个类型，同时考虑扩容问题
     */
    public void add(E e) {
//        1.什么时候扩容?
        if (size == elementData.length) {
            // 2.怎么扩容
            // 注意这里优先级的问题。>>的优先级小于+，10+10/2=15
            Object[] newArray = new Object[elementData.length + (elementData.length >> 1)];
            System.arraycopy(elementData, 0, newArray, 0, elementData.length);
            // 这里需要覆盖引用地址
            elementData = newArray;
        }
        // size成员变量，默认初始为0，添加完之后，后置++
        elementData[size++] = e;
    }

    public static void main(String[] args) {
        CjsArrayList03<String> list03 = new CjsArrayList03<>();
        for (int i = 0; i < 100; i++) {
            list03.add("123" + i);
        }
        System.out.println(list03);
    }
}
