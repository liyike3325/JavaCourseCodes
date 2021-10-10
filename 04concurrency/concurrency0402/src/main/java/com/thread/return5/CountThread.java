package com.thread.return5;

import java.util.concurrent.CountDownLatch;

/**
 * 统计线程
 */
public class CountThread extends Thread {

    private Entity entity;

    private CountDownLatch latch;

    private int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }

    private int sum() {
        return fibo(36);
    }

    CountThread(Entity entity, CountDownLatch latch) {
        this.entity = entity;
        this.latch = latch;
    }

    public void run() {
        entity.result = sum();
        latch.countDown();
    }
}
