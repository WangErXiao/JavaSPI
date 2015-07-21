package com.yao.common.status;

/**
 * Created by yao on 15/7/21.
 */
public class MemoryStatusChecker {

    public static void check(){
        Runtime runtime=Runtime.getRuntime();

        long freeMemory=runtime.freeMemory();

        long totalMemory=runtime.totalMemory();

        long maxMemory=runtime.maxMemory();

        long remainMemory=(maxMemory-(totalMemory-freeMemory));
        System.out.println("freeMemory:"+freeMemory+" totalMemory:"
                +totalMemory+" maxMemory:"+maxMemory+" remainMemory:"+remainMemory);

    }
    public static void main(String[]args){
        check();

    }

}
