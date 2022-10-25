package com.lakers.entity.thread;

/**
 * Created on 2022/10/14 9:17
 *
 * @author Lakers
 */
public class Test2 {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello");
        });
        System.out.println("start");
        t.start();
        // 等待t线程结束后再继续运行
        t.join(4000);
        System.out.println("end");
    }
}
