package com.thread.return2;

import com.thread.return2.CountThread;
import com.thread.return2.Entity;

/**
 * 获取线程返回值方法2
 * Thread的join方法来阻塞主线程，直到子线程返回
 */
public class Return2Application {

    public static void main(String[] args) throws InterruptedException {

        long start=System.currentTimeMillis();

        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        Entity entity = new Entity();
        CountThread countThread = new CountThread(entity);
        countThread.start();

        // 获取子线程返回值：
        // 在线程Return2Application中调用线程countThread的join方法，
        // 直到线程countThread执行完毕后，才会继续执行线程Return2Application
        countThread.join();

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+entity.result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
    }


}
