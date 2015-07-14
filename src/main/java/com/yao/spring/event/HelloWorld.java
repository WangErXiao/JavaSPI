package com.yao.spring.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by yao on 15/7/14.
 */
public class HelloWorld implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
    public void say(){
        System.out.println("hello world");
        applicationContext.publishEvent(new MyApplicationEvent("say hello world---"));
    }
}
