package com.lakers.entity.thread;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created on 2022/10/20 16:42
 *
 * @author Lakers
 */
public class Test12 {

    private List<String> list = new CopyOnWriteArrayList<>();

    private Set<String> set = new CopyOnWriteArraySet<>();

    private Map<String, String> map = new ConcurrentHashMap<>();

    private Queue<String> arrayQueue = new ArrayBlockingQueue<>(16);

    private Queue<String> linkedQueue = new LinkedBlockingQueue<>();

    public static AtomicInteger num = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 1000000000; i++) {
                num.getAndAdd(1);
            }
            System.out.println(Thread.currentThread().getName() + "执行结束!");
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
        Thread.sleep(1000);
        System.out.println("num = " + num);
    }

}
