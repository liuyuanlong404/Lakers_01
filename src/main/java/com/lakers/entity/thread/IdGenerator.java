package com.lakers.entity.thread;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created on 2022/10/21 16:32
 *
 * @author Lakers
 */
public class IdGenerator {

    AtomicLong var = new AtomicLong(0);

    public long getNextId() {
        return var.incrementAndGet();
    }
}
