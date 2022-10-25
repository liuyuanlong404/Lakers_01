package com.lakers.entity.thread.pool;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2022/10/24 10:35
 *
 * @author Lakers
 */
public class Test8 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //任务一
        CompletableFuture<String> makeUpFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "-女神：我开始化妆了。");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "化妆完毕了。";
        }, executorService);

        //任务二（makeUpFuture是方法调用方，意思是等makeUpFuture执行完成后执行再执行）
        CompletableFuture<String> dressFuture = makeUpFuture.thenApply(makeUp -> {
            System.out.println(Thread.currentThread().getName() + "-女神：" + makeUp + "我开始选衣服啦，好了我叫你。");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return makeUp + "衣服也选好啦。靓仔,走去玩儿吧。";
        });

        //获取结果
        dressFuture.thenAcceptAsync(result -> {
            System.out.println(Thread.currentThread().getName() + "-" + result);
        });
    }
}
