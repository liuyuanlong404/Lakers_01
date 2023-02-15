package com.lakers.entity;

import java.math.BigInteger;
import java.util.Objects;

/**
 * Created on 2022/10/8 10:23
 *
 * @author Lakers
 */
public class Animal {

    private String name;

    private int age;

    public Animal() {
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        int number = 100;
        BigInteger factorial = BigInteger.valueOf(1);
        for (int i = 1; i <= number; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        System.out.println("Factorial of " + number + " is: " + factorial);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Animal animal)) {
            return false;
        }
        return getAge() == animal.getAge() && Objects.equals(getName(), animal.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }

}
