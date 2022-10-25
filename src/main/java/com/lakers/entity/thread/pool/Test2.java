package com.lakers.entity.thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2022/10/22 10:35
 *
 * @author Lakers
 */
public class Test2 {

    public static void main(String[] args) {
        ScheduledExecutorService es = Executors.newScheduledThreadPool(4);
        // 1秒后执行一次性任务:
        es.schedule(new Task("one-time"), 1, TimeUnit.SECONDS);
        // 2秒后开始执行定时任务，每3秒执行:
        es.scheduleAtFixedRate(new Task("fixed-rate"), 2, 3, TimeUnit.SECONDS);
        // 2秒后开始执行定时任务，以3秒为间隔执行:
        es.scheduleWithFixedDelay(new Task("fixed-delay"), 2, 3, TimeUnit.SECONDS);
    }
}
