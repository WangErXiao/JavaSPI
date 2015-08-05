package com.yao.utils;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yao on 15/8/5.
 */
public class NamedThreadFactory implements ThreadFactory {


    private static final AtomicInteger POOL_SEQ =new AtomicInteger(1);

    private final AtomicInteger mThreadNum=new AtomicInteger(1);

    private final String mPrefix;

    private final boolean mDaemo;

    private final ThreadGroup mGroup;


    public NamedThreadFactory(){
        this("pool-"+POOL_SEQ.getAndIncrement(),false);
    }
    public NamedThreadFactory(String prefix){
        this(prefix,false);

    }
    public NamedThreadFactory(String prefix,boolean daemon){
        mPrefix=prefix+"-thread-";
        mDaemo=daemon;
        SecurityManager s=System.getSecurityManager();
        mGroup=(s==null)?Thread.currentThread().getThreadGroup():s.getThreadGroup();

    }


    @Override
    public Thread newThread(Runnable r) {
        String name=mPrefix+mThreadNum.getAndIncrement();
        Thread ret=new Thread(mGroup,r,name,0);
        return ret;
    }

    public ThreadGroup getThreadGroup(){
        return mGroup;
    }

}
