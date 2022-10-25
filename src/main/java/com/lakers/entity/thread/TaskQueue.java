package com.lakers.entity.thread;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created on 2022/10/18 14:21
 *
 * @author Lakers
 */
public class TaskQueue {

    Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String s) {
        this.queue.add(s);
        this.notifyAll();
    }

    public synchronized String getTask() throws InterruptedException {
        while (queue.isEmpty()){
            this.wait();
        }
        return queue.poll();
    }

}
