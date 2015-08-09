package com.yao.intrumentation;

import java.lang.instrument.Instrumentation;

/**
 * Created by yao on 15/8/9.
 */
public class MainAgent {
    public static void agentmain(String args, Instrumentation inst){
        Class[] classes = inst.getAllLoadedClasses();
        for(Class cls :classes){
            System.out.println(cls.getName());
        }

    }
}
