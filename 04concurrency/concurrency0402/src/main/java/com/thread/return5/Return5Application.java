package com.thread.return5;

import java.util.concurrent.CountDownLatch;

/**
 * 获取线程返回值方法5
 * CountDownLatch await等待子线程把任务执行完
 */
public class Return5Application {

    public static void main(String[] args) throws InterruptedException {
        long start=System.currentTimeMillis();

        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        Entity entity = new Entity();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        CountThread countThread = new CountThread(entity, countDownLatch);
        countThread.start();
        // 获取子线程返回值：
        // CountDownLatch await等待子线程把任务执行完
        countDownLatch.await();

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+entity.result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
}
