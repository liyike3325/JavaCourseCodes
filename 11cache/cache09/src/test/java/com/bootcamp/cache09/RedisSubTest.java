package com.bootcamp.cache09;

import com.bootcamp.cache09.service.RedisMsgPubSubListener;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

@SpringBootTest
public class RedisSubTest {

    @Autowired
    RedisMsgPubSubListener sp;

    /**
     * 异步收到订单消息，并创建订单
     */
    @Test
    public void subjava() {
        System.out.println("订阅者");
        Jedis jr = null;
        try {
            jr = new Jedis("127.0.0.1", 6379, 0);
            jr.subscribe(sp, "order.create");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jr != null) {
                jr.disconnect();
            }
        }
    }
}
