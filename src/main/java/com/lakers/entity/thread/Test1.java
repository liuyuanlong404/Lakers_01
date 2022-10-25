package com.lakers.entity.thread;

/**
 * Created on 2022/10/13 10:29
 *
 * @author Lakers
 */
public class Test1 {

    public static void main(String[] args) {
        System.out.println("main start...");
        Thread t = new Thread(() -> {
            System.out.println("thread run...");
            System.out.println("thread end.");
        });

        t.start();
        System.out.println("main end...");
    }
}
