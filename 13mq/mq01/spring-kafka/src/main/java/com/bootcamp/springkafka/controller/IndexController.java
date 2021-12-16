package com.bootcamp.springkafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @Autowired
    KafkaTemplate<String, String> template;

    /**
     * 生产者
     * @return
     */
    @RequestMapping("/send")
    @ResponseBody
    public String send() {
        template.send("test32", "hello spring kafka");
        return "success";
    }
}
