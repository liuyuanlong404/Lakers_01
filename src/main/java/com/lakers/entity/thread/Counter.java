package com.lakers.entity.thread;

/**
 * Created on 2022/10/18 13:45
 *
 * @author Lakers
 */
public class Counter {

    private int count = 0;

    public void add(int n) {
        synchronized (this) {
            count += n;
        }
    }

    public void dec(int n) {
        synchronized (this) {
            count -= n;
        }
    }

    public int getCount() {
        return count;
    }
}
