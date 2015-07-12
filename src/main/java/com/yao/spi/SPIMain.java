package com.yao.spi;

import java.util.ServiceLoader;

/**
 * Created by yao on 15/7/12.
 */
public class SPIMain {
    public static void main(String[]args){
        ServiceLoader<HelloWorld> loader=ServiceLoader.load(HelloWorld.class);
        for (HelloWorld helloWorld:loader){
            helloWorld.sayHello();
        }
    }
}
