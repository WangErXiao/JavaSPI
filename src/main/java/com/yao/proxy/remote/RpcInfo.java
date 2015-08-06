package com.yao.proxy.remote;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * Created by yao on 15/8/6.
 */
public class RpcInfo implements Serializable{

    private String className;

    private String  methodName;

    private Object[] args;

    public RpcInfo(String className, String methodName, Object[] args) {
        this.className = className;
        this.methodName = methodName;
        this.args = args;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
