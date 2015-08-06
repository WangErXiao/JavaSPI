package com.yao.proxy;

import com.yao.proxy.remote.Client;
import com.yao.proxy.remote.RpcInfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by yao on 15/8/6.
 */
public class MyInocatioinHandler implements InvocationHandler {
    private static final Client client=new Client();

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String className= method.getDeclaringClass().getName();

        return client.invoke(new RpcInfo(className,method.getName(),args));

    }
}
