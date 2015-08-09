package com.yao.intrumentation;

import java.lang.instrument.Instrumentation;

/**
 * Created by yao on 15/8/9.
 */
public class MyAgent {

    /**
     * 该方法是一个类作为agent类必备的
     * @param agentArgs
     * @param inst
     */
    public static void premain(String agentArgs,Instrumentation inst){

        //加入ClassFileTransfomer
        inst.addTransformer(new PeopleClassFileTransformer());
    }

}
