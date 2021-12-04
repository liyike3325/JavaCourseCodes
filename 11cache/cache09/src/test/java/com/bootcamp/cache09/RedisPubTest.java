package com.bootcamp.cache09;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

public class RedisPubTest {

    /**
     * 发送一个创建订单消息
     * @throws JSONException
     */
    @Test
    public void pubjava() throws JSONException {
        System.out.println("发布者");
        JSONObject order = new JSONObject();
        order.put("uid", 1);
        order.put("tid", "TN001");
        order.put("oid", "ON001");
        order.put("item_id", 1);
        order.put("quantity", 1);
        order.put("price", 100.00);
        order.put("total_fee", 100.00);
        order.put("payment", 100.00);
        order.put("item_name", "水果");
        order.put("status", "TRADE_FINISHED");
        String message = order.toString();

        Jedis jr = null;
        try {
            jr = new Jedis("127.0.0.1", 6379, 0);
            jr.publish("order.create", message);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jr != null) {
                jr.disconnect();
            }
        }
    }
}
