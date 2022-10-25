package com.lakers.entity.thread.pool;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;

/**
 * Created on 2022/10/22 10:51
 *
 * @author Lakers
 */
public class Task2 implements Callable<String> {

    @Override
    public String call() {
        return LocalDateTime.now().toString();
    }
}
