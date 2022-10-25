package com.lakers.entity.thread.pool;

import java.util.concurrent.CompletableFuture;

/**
 * Created on 2022/10/22 11:12
 *
 * @author Lakers
 */
public class Test4 {

    public static void main(String[] args) throws InterruptedException {
        // 创建异步执行任务:
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(Test4::fetchPrice);
        // 如果执行成功:
        cf.thenAccept(result -> System.out.println("price: " + result));
        // 如果执行异常:
        cf.exceptionally(e -> {
            e.printStackTrace();
            return null;
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(200);
    }

    public static Double fetchPrice() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
        if (Math.random() < 0.5D) {
            throw new RuntimeException("fetch price failed!");
        }
        return 5 + Math.random() * 20;
    }
}
