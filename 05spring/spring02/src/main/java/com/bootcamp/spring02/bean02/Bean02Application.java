package com.bootcamp.spring02.bean02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring bean装配，方法二:使用@Autowired注释，完成自动装配
 */
public class Bean02Application {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean02.xml");
        Boss boss = (Boss) context.getBean("boss");
        System.out.println(boss);
    }
}
