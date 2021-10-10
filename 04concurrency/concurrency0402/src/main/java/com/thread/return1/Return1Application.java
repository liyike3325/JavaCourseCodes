package com.thread.return1;

/**
 * 获取线程返回值方法1
 * 主线程循环等待
 */
public class Return1Application {

    public static void main(String[] args) throws InterruptedException {

        long start=System.currentTimeMillis();

        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        Entity entity = new Entity();
        CountThread countThread = new CountThread(entity);
        countThread.start();

        // 获取子线程返回值：
        // 主线程循环等待
        while (entity.result == 0) {
            System.out.println("休眠1秒");
            Thread.sleep(1000);
        }

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+entity.result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
    }


}
