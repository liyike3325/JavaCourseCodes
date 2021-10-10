package com.thread.return2;

import com.thread.return2.Entity;

/**
 * 统计线程
 */
public class CountThread extends Thread {

    Entity entity;

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }

    private static int sum() {
        return fibo(36);
    }

    CountThread(Entity entity) {
        this.entity = entity;
    }

    public void run() {
        this.entity.result = sum();
    }
}
