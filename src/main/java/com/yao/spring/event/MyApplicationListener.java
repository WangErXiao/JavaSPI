package com.yao.spring.event;

import org.springframework.context.ApplicationListener;

/**
 * Created by yao on 15/7/14.
 */
public class MyApplicationListener implements ApplicationListener<MyApplicationEvent> {
        @Override
        public void onApplicationEvent(MyApplicationEvent myApplicationEvent) {
                System.out.println("event occur:"+myApplicationEvent.getSource());
        }
}
