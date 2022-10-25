package com.lakers.entity.thread.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created on 2022/10/22 10:54
 *
 * @author Lakers
 */
public class Test3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(4);
        Callable<String> task = new Task2();
        Future<String> future = es.submit(task);
        String s = future.get();
        System.out.println(s);
    }
}
