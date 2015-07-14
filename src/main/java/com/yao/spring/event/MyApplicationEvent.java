package com.yao.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by yao on 15/7/14.
 */


public class MyApplicationEvent extends ApplicationEvent {

        public MyApplicationEvent(Object source) {
                super(source);
        }

}
