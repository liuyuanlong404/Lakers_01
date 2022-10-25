package com.lakers.entity.thread.pool;

/**
 * Created on 2022/10/22 10:19
 *
 * @author Lakers
 */
public class Task implements Runnable {

    private final String name;

    public Task(String name) {
        this.name = name;
    }


    @Override
    public void run() {
        System.out.println("start task " + name);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ignored) {
        }
        System.out.println("end task " + name);
    }
}
