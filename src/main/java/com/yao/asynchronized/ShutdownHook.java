package com.yao.asynchronized;

/**
 * Created by yao on 15/8/13.
 */
public class ShutdownHook {
    public static void main(String[]args){

        Thread shutdownHook=new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("close some resource......");
                try {
                    Thread.sleep(1000*3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println("finish----------");
                }

            }
        });
        Runtime.getRuntime().addShutdownHook(shutdownHook);

        System.out.println("close appliaction");
    }
}
