package com.thread.return4;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 获取线程返回值方法4
 * 通过FutureTask获取异步线程执行结果
 */
public class Return4Application {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start=System.currentTimeMillis();

        // 获取子线程返回值：
        // 通过FutureTask获取异步线程执行结果
        Callable<Integer> task = new CountCallable();
        FutureTask futureTask = new FutureTask(task);
        Thread thread = new Thread(futureTask);
        thread.start();

        System.out.println("异步计算结果为：" + futureTask.get());
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
}
