package com.yao.proxy;

/**
 * Created by yao on 15/8/6.
 */
public class HelloWorldImpl implements HelloWorld {
    @Override
    public String sayHello(String name) {
        return "hello world "+name;
    }
}
