package com.lakers.entity;

/**
 * Created on 2022/11/19 15:55
 *
 * @author lakers
 */
public class Child extends Parent {

    public static void print() {
        System.out.println("I am Child");
    }

    public static void main(String[] args) {
        Child child = new Child();
        Parent parent = child;
        Parent.print();
        Child.print();
    }
}
