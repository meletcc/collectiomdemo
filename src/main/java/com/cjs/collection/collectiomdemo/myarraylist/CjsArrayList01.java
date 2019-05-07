package com.cjs.collection.collectiomdemo.myarraylist;

/**
 * 自定义实现一个ArrayList，理解底层原理
 * 第一版本：仅提供容器功能
 *
 * @author 陈峻松
 * @date 2019/4/12
 */
public class CjsArrayList01 {

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
    public CjsArrayList01() {
        elementData = new Object[DEFALT_CAPACITY];
    }

    /**
     * 重载构造
     *
     * @param capacity 想要的容量
     */
    public CjsArrayList01(int capacity) {
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
        // 可以直接打印sb
        return sb.toString();
    }

    /**
     * 往容器后依次追加元素
     */
    public void add(Object object) {
        // size成员变量，默认初始为0，添加完之后，后置++
        elementData[size++] = object;
    }

    /**
     * 每个类都可以有main方法，但每个类只能有一个完全相同的main方法
     * 具体以哪个类的main方法为入口，可以设置
     *
     * @param args 字符串数组参数
     */
    public static void main(String[] args) {
        CjsArrayList01 list01 = new CjsArrayList01(20);
        list01.add("aa");
        list01.add("bb");
        System.out.println(list01);
    }
}
