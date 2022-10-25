package com.lakers.entity.thread;

/**
 * Created on 2022/10/18 11:52
 *
 * @author Lakers
 */
public class Test6 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main begin....");
        Thread thread = new MyThread2();
        thread.setName("线程A");
        thread.setDaemon(true);
        thread.start();
        System.out.println("main end.....");
    }
}

class MyThread2 extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"   begin....");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"   end.....");
    }
}


