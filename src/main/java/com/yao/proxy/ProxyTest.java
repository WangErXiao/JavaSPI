package com.yao.proxy;

/**
 * Created by yao on 15/8/6.
 */
public class ProxyTest {
    public static void main(String[]args){
        ProxyFacotry facotry=new ProxyFacotry();
        HelloWorld helloWorld=facotry.getProxy(new Class[]{HelloWorld.class});
        System.out.println(helloWorld.sayHello("yao"));
    }
}
