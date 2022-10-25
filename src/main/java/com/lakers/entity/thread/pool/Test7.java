package com.lakers.entity.thread.pool;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2022/10/24 9:53
 *
 * @author Lakers
 */
public class Test7 {

    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "-女神：我开始化妆了，好了我叫你。");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "化妆完毕了。";
        }, executorService).whenCompleteAsync((returnStr, exception) -> {
            if (exception == null) {
                System.out.println(Thread.currentThread().getName() + returnStr);
            } else {
                System.out.println(Thread.currentThread().getName() + "女神放你鸽子了。");
                exception.printStackTrace();
            }
        }, executorService);
        System.out.println(Thread.currentThread().getName() + "-等女神化妆的时候可以干点自己的事情。");
//        Thread.currentThread().join();
    }
}
