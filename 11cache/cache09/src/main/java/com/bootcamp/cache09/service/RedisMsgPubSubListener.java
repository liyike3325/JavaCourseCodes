package com.bootcamp.cache09.service;

import com.alibaba.fastjson.JSON;
import com.bootcamp.cache09.entity.BsOrder;
import com.bootcamp.cache09.mapper.BsOrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPubSub;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * redis发布订阅消息监听器
 */
@Component
public class RedisMsgPubSubListener extends JedisPubSub {

    private Logger logger = LoggerFactory.getLogger(RedisMsgPubSubListener.class);

    @Autowired
    BsOrderMapper bsOrderMapper;

    @Override
    public void onMessage(String channel, String message) {
        logger.info("onMessage: channel[{}], message[{}]", channel, message);
        Map maps = (Map)JSON.parse(message);
        // 创建订单
        BsOrder bsOrder = new BsOrder();
        bsOrder.setUid((Integer) maps.get("uid"));
        bsOrder.setTid((String) maps.get("tid"));
        bsOrder.setOid((String) maps.get("oid"));
        bsOrder.setItemId((Integer) maps.get("item_id"));
        bsOrder.setQuantity((Integer) maps.get("quantity"));
        bsOrder.setPrice(new BigDecimal(maps.get("price").toString()));
        bsOrder.setTotalFee(new BigDecimal(maps.get("total_fee").toString()));
        bsOrder.setPayment(new BigDecimal(maps.get("payment").toString()));
        bsOrder.setItemName((String) maps.get("item_name"));
        bsOrder.setStatus((String) maps.get("status"));
        bsOrder.setCreateTime(new Date());
        bsOrder.setUpdateTime(new Date());
        bsOrderMapper.insert(bsOrder);
        logger.info("创建订单成功");
    }
}
