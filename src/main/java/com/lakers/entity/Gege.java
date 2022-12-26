package com.lakers.entity;

/**
 * Created on 2022/11/19 15:29
 *
 * @author lakers
 */
public class Gege implements Baba, Mama {


    public static void main(String[] args) {
        float x = 18f / 100f;
        System.out.println(x);
    }

    @Override
    public void print() {
        Baba.super.print();
    }
}
