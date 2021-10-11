package com.thread.return6;

import java.util.concurrent.CountDownLatch;

/**
 * 获取线程返回值方法6
 * CountDownLatch await等待子线程把任务执行完
 * 取出entity.result的值
 */
public class Return6Application {

    public static void main(String[] args) throws InterruptedException {
        long start=System.currentTimeMillis();

        Entity entity = new Entity();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        CountThread countThread = new CountThread(entity, countDownLatch);
        countThread.start();
        // CountDownLatch await等待子线程把任务执行完
        countDownLatch.await();

        System.out.println("异步计算结果为："+entity.result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
}
