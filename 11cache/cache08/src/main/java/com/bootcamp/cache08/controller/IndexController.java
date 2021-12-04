package com.bootcamp.cache08.controller;

import com.bootcamp.cache08.service.RedisLock;
import com.bootcamp.cache08.util.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
public class IndexController {

    @Autowired
    RedisLock redisLock;

    // 库存
    int stock = 2000;

    @RequestMapping("/index")
    @ResponseBody
    public String index() throws InterruptedException {
        int clientcount = 1000;
        CountDownLatch countDownLatch = new CountDownLatch(clientcount);
        ExecutorService executorService = Executors.newFixedThreadPool(clientcount);
        long start = System.currentTimeMillis();
        for (int i = 0; i < clientcount; i++) {
            executorService.execute(() -> {
                String id = KeyUtil.genUniqueKey();
                try {
                    redisLock.lock(id);
                    // 模拟减库存
                    stock--;
                } finally {
                    redisLock.unlock(id);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        long end = System.currentTimeMillis();
        String seconds = String.format("%.2f", (end - start) / 1000.0);
        System.out.println("执行线程数:" + clientcount + ",总耗时:" + seconds + "秒,库存数为:" + stock);
        return "Hello";
    }
}
