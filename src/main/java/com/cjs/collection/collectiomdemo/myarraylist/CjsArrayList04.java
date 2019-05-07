package com.cjs.collection.collectiomdemo.myarraylist;

/**
 * 自定义实现一个ArrayList，理解底层原理
 * 第四版本：增加set、get方法；
 * 增加数组边界检查
 *
 * @author 陈峻松
 * @date 2019/4/12
 */
public class CjsArrayList04<E> {

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
    public CjsArrayList04() {
        elementData = new Object[DEFALT_CAPACITY];
    }

    /**
     * 重载构造
     *
     * @param capacity 想要的容量
     */
    public CjsArrayList04(int capacity) {
        if (capacity < 0) {
            throw new RuntimeException("容器容量不能小于0");
        } else if (capacity == 0) {
            elementData = new Object[DEFALT_CAPACITY];
        } else {
            elementData = new Object[capacity];
        }
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

    /**
     * set方法
     *
     * @param newElement 设置的新元素
     * @param index      设置位置
     */
    public void set(E newElement, int index) {
        checkIndex(index);
        elementData[index] = newElement;
    }

    /**
     * get方法
     *
     * @param index 索引
     * @return 该索引地址元素
     */
    public E get(int index) {
        checkIndex(index);
        return (E) elementData[index];
    }

    /**
     * 索引范围检查
     */
    private void checkIndex(int index) {
        if (index < 0 || index > size - 1) {
            // 不合法
            throw new RuntimeException("索引越界" + index);
        }
    }

    /**
     * 删除指定下标元素
     * a,b,c,d
     * a,c,d
     *
     * @param index 下标
     */
    public void remove(int index) {
        checkIndex(index);
        int moverdNum = elementData.length - index - 1;
        if (moverdNum > 0) {
            // 被拷贝的数组；从拷贝数组哪个下标开始拷；拷贝到新数组；从新数组开始索引；复制的大小
            System.arraycopy(elementData, index + 1, elementData, index, moverdNum);
        }

        // 如果删除最后一个,moverdNum == 0的情况，最后元素置为空
        elementData[--size] = null;
    }

    /**
     * 删除指定元素
     *
     * @param element 要删除的元素
     */
    public void remove(E element) {
        // 将element和所有元素比较，获得第一个为true的。返回
        for (int i = 0; i < size; i++) {
            // 容器中的所有比较操作都有equals方法
            if (element.equals(get(i))) {
                remove(i);
            }
        }
        throw new RuntimeException("没有该元素");
    }

    /**
     * 获得容器大小
     *
     * @return 容器大小
     */
    public int size() {
        return size;
    }

    /**
     * 看容器是否为空
     *
     * @return 是否为空
     */
    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    public static void main(String[] args) {
        CjsArrayList04<String> list03 = new CjsArrayList04<>();
        for (int i = 0; i < 20; i++) {
            list03.add("123" + i);
        }
        System.out.println(list03);

        list03.set("cjs", 10);
        System.out.println(list03);
        System.out.println(list03.get(10));
        list03.remove(10);
        System.out.println(list03);
        list03.remove("123");
        System.out.println(list03);
    }
}
