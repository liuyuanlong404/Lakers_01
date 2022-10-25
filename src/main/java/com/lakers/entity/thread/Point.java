package com.lakers.entity.thread;

import java.util.concurrent.locks.StampedLock;

/**
 * Created on 2022/10/21 10:10
 *
 * @author Lakers
 */
public class Point {

    private final StampedLock lock = new StampedLock();

    private double x;

    private double y;

    public void move(double deltaX, double deltaY) {
        // 获取写锁
        long writeLock = lock.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            // 释放写锁
            lock.unlockWrite(writeLock);
        }
    }

    public double distanceFromOrigin(){
        // 获得一个乐观读锁
        long stamp = lock.tryOptimisticRead();
        // 注意下面两行代码不是原子操作
        // 假设x,y = (100,200)
        double currentX = x;
        // 此处已读取到x=100，但x,y可能被写线程修改为(300,400)
        double currentY = y;
        // 此处已读取到y，如果没有写入，读取是正确的(100,200)
        // 如果有写入，读取是错误的(100,400)
        // 检查乐观读锁后是否有其他写锁发生
        if (!lock.validate(stamp)) {
            // 获取一个悲观读锁
            stamp = lock.readLock();
            try {
                currentX = x;
                currentY = y;
            } finally {
                // 释放悲观读锁
                lock.unlockRead(stamp);
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }
}
