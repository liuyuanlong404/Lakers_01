package com.lakers.entity.thread;

/**
 * Created on 2022/10/18 13:48
 *
 * @author Lakers
 */
public class Test8 {
    public static void main(String[] args) {
        var c1 = new Counter();
        var c2 = new Counter();
        new Thread(() -> c1.add(5)).start();
        new Thread(() -> c2.dec(5)).start();

        new Thread(() -> c2.add(500)).start();
        new Thread(() -> c2.dec(500)).start();

    }
}
