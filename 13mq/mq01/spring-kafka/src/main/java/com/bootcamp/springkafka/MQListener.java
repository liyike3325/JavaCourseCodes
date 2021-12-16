package com.bootcamp.springkafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MQListener {

    /**
     * 消费者
     * @param in
     */
    @KafkaListener(id = "myId", topics = "test32")
    public void listen(String in) {
        System.out.println(in);
    }
}
