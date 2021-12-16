package io.kimmking.kmq.core;

import lombok.SneakyThrows;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 第二个版本
 * queue改用KmqMessage数组
 * producerOffset记录当前消息写入位置，类型为AtomicInteger，保证线程安全
 * consumerOffset记录消费位置，类型为AtomicInteger，保证线程安全
 */
public final class Kmq {

    public Kmq(String topic, int capacity) {
        this.topic = topic;
        this.capacity = capacity;
        this.queue = new KmqMessage[capacity];
    }

    private String topic;

    private int capacity;

    // queue改用数组
    private KmqMessage[] queue;

    // 消息写入位置
    private AtomicInteger producerOffset = new AtomicInteger(0);

    // 消费位置
    private AtomicInteger consumerOffset = new AtomicInteger(0);

    public boolean send(KmqMessage message) {
        int index = producerOffset.getAndIncrement();
        queue[index] = message;
        if (index >= 100) {
            System.out.println("index=" + index);
        }
        return true;
    }

    public KmqMessage poll() {
        int index = consumerOffset.getAndIncrement();
        KmqMessage message = queue[index];
        return message;
    }

    @SneakyThrows
    public KmqMessage poll(long timeout) {
        Thread.currentThread().sleep(timeout);
        int nextIndex = consumerOffset.get();
        // 防止没有数据了还在那里消费
        if (queue[nextIndex] == null) {
            return null;
        }
        int index = consumerOffset.getAndIncrement();
        KmqMessage message = queue[index];
        return message;
    }

}
