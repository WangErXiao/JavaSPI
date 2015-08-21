package com.yao.concurrent.collection.countdown;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yao on 15/8/21.
 *
 * 利用多线程计算大list所有数的集合
 */
public class CountBigList {

    private long rel;

    private CountDownLatch countDownLatch;

    private List<Integer> list;

    private  int threadCounts;

    public CountBigList(List<Integer> list,int threadCounts) {
        this.threadCounts=threadCounts;
        this.countDownLatch = new CountDownLatch(threadCounts);
        this.list = list;
    }

    public long sum() throws InterruptedException {

        ExecutorService service= Executors.newFixedThreadPool(4);

        List<CalRunable>rels=new ArrayList<>();
        int length=list.size();
        int interval=length/threadCounts;
        for (int i=0;i<threadCounts;i++){
            List<Integer>subList=list.subList(i*interval,(i+1)*interval);
            CalRunable calRunable=new CalRunable(subList,countDownLatch);
            rels.add(calRunable);
            service.submit(calRunable);
        }
        countDownLatch.await();

        for (CalRunable calRunable:rels){
            rel+=calRunable.getRel();
        }
        return rel;

    }

    private static class CalRunable implements Runnable{

        private List<Integer>list;
        private CountDownLatch countDownLatch;

        private long rel=0;

        public CalRunable(List<Integer> list, CountDownLatch countDownLatch) {
            this.list = list;
            this.countDownLatch = countDownLatch;
        }
        public long getRel() {
            return rel;
        }

        public void setRel(long rel) {
            this.rel = rel;
        }

        @Override
        public void run() {
            for(Integer ele:list){
                rel+=ele;
            }
            countDownLatch.countDown();
        }
    }


}
