package com.thread.return3;

import java.util.concurrent.*;

/**
 * 获取线程返回值方法3
 * 使用Future获得异步执行结果，调用阻塞方法get()
 */
public class Return3Application {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start=System.currentTimeMillis();

        // 创建线程池，实现Callable接口，future.get()将阻塞，直至结果准备就绪
        Callable<Integer> task = new CountCallable();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> future = executorService.submit(task);

        System.out.println("异步计算结果为：" + future.get());
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
}
