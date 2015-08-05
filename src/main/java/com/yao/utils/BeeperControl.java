package com.yao.utils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by yao on 15/8/5.
 */
public class BeeperControl {

    private final ScheduledExecutorService scheduler= Executors.newScheduledThreadPool(1);

    public void beepForAndHour() throws InterruptedException {
        final Runnable beeper=new Runnable() {
            @Override
            public void run() {
                System.out.println("beep");
            }
        };
        final ScheduledFuture<?> beeperHandler=scheduler.scheduleAtFixedRate(beeper,10,10, TimeUnit.SECONDS);
        scheduler.schedule(new Runnable() {
            @Override
            public void run() {
                beeperHandler.cancel(true);
            }
        },60,TimeUnit.SECONDS);

        scheduler.awaitTermination(60*2,TimeUnit.SECONDS);

    }


}
