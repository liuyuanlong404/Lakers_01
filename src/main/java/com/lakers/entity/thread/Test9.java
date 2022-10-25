package com.lakers.entity.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2022/10/19 16:06
 *
 * @author Lakers
 */
public class Test9 {

    public static void main(String[] args) throws InterruptedException {
        TaskQueue2 q = new TaskQueue2();
        List<Thread> ts = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            var t = new Thread(() -> {
                // 执行task:
                while (true) {
                    try {
                        String s = q.getTask();
                        System.out.println(Thread.currentThread().getName() + "执行: " + s);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            });
            t.start();
            ts.add(t);
        }
        var add = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                // 放入task:
                String s = "任务-" + i;
                System.out.println("添加任务: " + s);
                q.addTask(s);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {
                }
            }
        });
        add.start();
        add.join();
        Thread.sleep(1000);
        for (Thread t : ts) {
            t.interrupt();
        }
    }
}
