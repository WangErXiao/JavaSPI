package com.yao.spring.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yao on 15/7/14.
 */
public class TestEvent {
    public static void main(String[]args){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath*:event/event.xml");
        HelloWorld helloWorld=applicationContext.getBean("helloWorld",HelloWorld.class);
        helloWorld.say();

    }
}
