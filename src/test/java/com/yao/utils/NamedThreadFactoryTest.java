package com.yao.utils;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by yao on 15/8/5.
 */
public class NamedThreadFactoryTest extends TestCase {

    @Test
    public void testNewThread() throws Exception {

        NamedThreadFactory factory=new NamedThreadFactory();

        ExecutorService service= Executors.newFixedThreadPool(5);

        service.submit(new Runnable() {
            @Override
            public void run() {
                factory.newThread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("hello world");
                        try {
                            Thread.currentThread().sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("finish----------"+factory.getThreadGroup());
                    }
                }).start();

            }
        });
        service.submit(new Runnable() {
            @Override
            public void run() {
                factory.newThread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("hello world");
                        try {
                            Thread.currentThread().sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("finish----------"+factory.getThreadGroup());
                    }
                }).start();

            }
        });
        service.submit(new Runnable() {
            @Override
            public void run() {
                factory.newThread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("hello world");
                        try {
                            Thread.currentThread().sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("finish----------"+factory.getThreadGroup());
                    }
                }).start();

            }
        });
        service.awaitTermination(3, TimeUnit.SECONDS);

        service.shutdown();
    }
}