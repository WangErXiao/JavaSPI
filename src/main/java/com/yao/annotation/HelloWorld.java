package com.yao.annotation;


/**
 * Created by yao on 15/8/27.
 */
public class HelloWorld {
    @Auth("auth")
    public void say(){
        System.out.println("hello world");
    }
    @Auth("auth1")
    public void say1(){
        System.out.println("hello world1");
    }
}
