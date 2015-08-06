package com.yao.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by yao on 15/8/6.
 */
public class ProxyFacotry {

    public <T> T getProxy(Class<?>[] interfaces) {
        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), interfaces,new MyInocatioinHandler());
    }

}
