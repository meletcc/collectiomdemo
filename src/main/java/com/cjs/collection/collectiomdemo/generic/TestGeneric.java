package com.cjs.collection.collectiomdemo.generic;

/**
 * 测试泛型
 */
public class TestGeneric {

    public static void main(String[] args) {

//        没使用泛型的缺点就是：集合能放任意对象，取出来的元素需要显示强制类型转换，容易出错
//        MyCollection myCollection = new MyCollection();
//        myCollection.set("String", 2);
//        myCollection.set(1234, 4);
//        String string = (String) myCollection.get(2);
//        Integer integer = (Integer) myCollection.get(4);

        // 这里相当于传入了一个数据类型的实际参数-String，只能传String类型
        MyCollection<String> objectMyCollection = new MyCollection<>();
        objectMyCollection.set("String", 0);
        String s = objectMyCollection.get(0);
        System.out.println(s);
    }

}

/**
 * 自定义集合（容器）
 * 使用泛型：<E\V\T>，这里相当于定义了一个数据类型的形式参数
 */
class MyCollection<E> {

    Object[] objects = new Object[5];

    public void set(E e, Integer index) {
        objects[index] = e;
    }

    public E get(Integer index) {
        return (E) objects[index];
    }

}