package com.yao.concurrent.collection.delay;

import org.omg.CORBA.TIMEOUT;

import java.util.Iterator;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by yao on 15/8/6.
 */
public class DelayQueueTest {

    public static void main(String... args) throws InterruptedException {
        DelayQueue dq=new DelayQueue();
        DelayedTest ob1=new DelayedTest(3,TimeUnit.SECONDS);
        DelayedTest ob2=new DelayedTest(2,TimeUnit.SECONDS);
        DelayedTest ob3=new DelayedTest(7,TimeUnit.SECONDS);

        dq.offer(ob1);
        dq.offer(ob2);
        dq.offer(ob3);

        while (true){
            System.out.println(((DelayedTest)dq.take()).delayTime);
        }
    }

}

class DelayedTest implements Delayed{

    public long delayTime=0;

    public long submitTime=0;
    DelayedTest(long deleyTime,TimeUnit unit){
        delayTime=deleyTime;
        submitTime=TimeUnit.NANOSECONDS.convert(deleyTime,unit)+System.nanoTime();
    }

    @Override
    public int compareTo(Delayed ob) {
        if(this.delayTime<((DelayedTest)ob).delayTime){
            return -1;
        }else if(this.delayTime>((DelayedTest)ob).delayTime){
            return 1;
        }
        return 0;
    }
    @Override
    public long getDelay(TimeUnit unit) {
       return unit.convert(submitTime - System.nanoTime(),  TimeUnit.NANOSECONDS);
    }


}
