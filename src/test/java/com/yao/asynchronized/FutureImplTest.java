package com.yao.asynchronized;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by yao on 15/8/13.
 */
public class FutureImplTest extends TestCase {


    @Test
    public void testGet() throws ExecutionException, InterruptedException {
        Future<String>future=doSomething();
        System.out.println("begin wait for result");
        System.out.println(future.get());

    }

    public Future<String> doSomething(){
        FutureImpl<String>future=new FutureImpl<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int rand=(int)(Math.random()*10);
                try {
                    Thread.sleep(rand*1000);
                } catch (InterruptedException e) {
                    future.failure(e);
                }
                future.setResult("do something take "+rand+ " time");
            }
        }).start();
        return future;
    }

}