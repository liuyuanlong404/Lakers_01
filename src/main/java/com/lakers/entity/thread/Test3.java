package com.lakers.entity.thread;

/**
 * Created on 2022/10/14 9:23
 *
 * @author Lakers
 */
public class Test3 {

    public static void main (String[] args) throws InterruptedException {
        Thread t = new MyThread1();
        t.start();
        Thread.sleep(4); // 暂停4毫秒
        t.interrupt(); // 中断t线程
        t.join(); // 等待t线程结束
        System.out.println("end");
    }

}
    class MyThread1 extends Thread {
        @Override
        public void run() {
            int n = 0;
            while (! isInterrupted()) {
                n ++;
                System.out.println(n + " hello!");
            }
        }
    }
