package com.thread.return5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 获取线程返回值方法5
 * 使用CompletableFuture，当异步任务执行完取得结果
 */
public class Return5Application {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        long start=System.currentTimeMillis();

        // 创建异步执行任务
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(Return5Application::sum);
        // 如果执行成功
        future.thenAccept((result) -> {
            System.out.println("异步计算结果为：" + result);
            System.out.println("使用时间："+ (System.currentTimeMillis() - start) + " ms");
        });
        // 如果执行异常
        future.exceptionally((e) -> {
            e.printStackTrace();
            return null;
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭
        Thread.sleep(200);
    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }

    private static int sum() {
        return fibo(36);
    }
}
