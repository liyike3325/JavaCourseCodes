package com.thread.return1;

/**
 * 获取线程返回值方法1
 * 创建一个Thread线程执行，主线程轮询看entity.result是否为0
 */
public class Return1Application {

    public static void main(String[] args) throws InterruptedException {
        long start=System.currentTimeMillis();

        // 创建一个Thread线程执行
        Entity entity = new Entity();
        CountThread countThread = new CountThread(entity);
        countThread.start();

        // 主线程轮询看entity.result是否为0
        while (entity.result == 0) {
            System.out.println("休眠1秒");
            Thread.sleep(1000);
        }

        System.out.println("异步计算结果为："+entity.result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }


}
