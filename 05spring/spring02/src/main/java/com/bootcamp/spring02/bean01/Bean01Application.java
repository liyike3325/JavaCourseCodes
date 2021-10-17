package com.bootcamp.spring02.bean01;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring bean装配，方法一:XML
 */
public class Bean01Application {

	public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean01.xml");
        Boss boss = (Boss) context.getBean("boss");
        System.out.println(boss);
	}
}
