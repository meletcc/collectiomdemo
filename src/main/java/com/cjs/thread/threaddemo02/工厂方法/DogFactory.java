package com.cjs.thread.threaddemo02.工厂方法;

public class DogFactory implements Factory {

    @Override
    public Animal createAnimal() {

        return new Dog();
    }

}
