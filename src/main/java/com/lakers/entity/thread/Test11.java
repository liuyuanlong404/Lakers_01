package com.lakers.entity.thread;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created on 2022/10/20 9:22
 * 悲观锁
 * @author Lakers
 */
public class Test11 {

    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock rLock = lock.readLock();
    private final Lock wLock = lock.writeLock();
    private int[] counts = new int[10];

    public void inc(int index){
        wLock.lock();
        try {
            counts[index] = 1;
        }finally {
            wLock.unlock();
        }

    }

    public int[] get(){
        rLock.lock();
        try {
            return Arrays.copyOf(counts, counts.length);
        }finally {
            rLock.unlock();
        }
    }
}
