package com.lakers.entity.thread;

/**
 * Created on 2022/10/18 13:27
 *
 * @author Lakers
 */
public class Test7 {

    public static void main(String[] args) throws Exception {
        var add = new AddThread();
        var dec = new DecThread();
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println(Counter1.count);
    }
}

class Counter1 {
    public static final Object lock = new Object();
    public static int count = 0;
}

class AddThread extends Thread {
    @Override
    public void run() {

        for (int i = 0; i < 10000; i++) {
            synchronized (Counter1.lock) {
                Counter1.count += 1;
            }
        }
    }
}

class DecThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (Counter1.lock) {
                Counter1.count -= 1;
            }
        }
    }
}
