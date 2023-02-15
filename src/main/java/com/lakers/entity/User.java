package com.lakers.entity;

import java.math.BigDecimal;

/**
 * Created on 2022/10/24 11:04
 *
 * @author Lakers
 */
public class User {

    private Integer id;

    private String name;

    public User() {
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {
        BigDecimal test = test(BigDecimal.valueOf(100));
        System.out.println(test);
    }

    public static BigDecimal test(BigDecimal n) {
        if (n.compareTo(BigDecimal.ONE) == 0) {
            return BigDecimal.ONE;
        }
        return n.multiply(test(n.subtract(BigDecimal.ONE)));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
