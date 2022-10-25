package com.lakers.entity.thread.pool;

import java.util.concurrent.CompletableFuture;

/**
 * Created on 2022/10/22 11:45
 *
 * @author Lakers
 */
public class Test5 {

    public static void main(String[] args) throws InterruptedException {
        // 第一个任务:
        CompletableFuture<String> cfQuery = CompletableFuture.supplyAsync(() -> queryCode("中国石油"));
        // cfQuery成功后继续执行下一个任务:
        CompletableFuture<Double> cfFetch = cfQuery.thenApplyAsync(Test5::fetchPrice);
        // cfFetch成功后打印结果:
        cfFetch.thenAccept(result -> System.out.println("price: " + result));
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(2000);
    }

    static String queryCode(String name) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
        return "601857";
    }

    static Double fetchPrice(String code) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
        return 5 + Math.random() * 20;
    }
}
