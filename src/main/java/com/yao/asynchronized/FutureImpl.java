package com.yao.asynchronized;

import java.util.concurrent.*;

/**
 * Created by yao on 15/8/13.
 */
public class FutureImpl<R> implements Future<R> {


        private final Object sync;

        private boolean isDone;

        private boolean isCancel;

        private Throwable failure;

        private R result;

        public FutureImpl(){
                this(new Object());
        }
        public FutureImpl(Object sync) {
                this.sync = sync;
        }


        public R getResult() {
                synchronized (this.sync){
                        return result;
                }
        }

        //下面是三个方法都要isDone=true;
        public void setResult(R result) {
                synchronized (this.sync){
                        this.result = result;
                        notifyHaveResult();
                }
        }

        @Override
        public boolean cancel(boolean mayInterruptIfRunning) {
                synchronized (this.sync){
                        isCancel=true;
                        notifyHaveResult();
                        return false;
                }

        }
        public void failure(Throwable failure) {
                synchronized (this.sync) {
                        this.failure = failure;
                        notifyHaveResult();
                }
        }

        @Override
        public boolean isCancelled() {
                synchronized (this.sync){
                        return this.isCancel;
                }
        }

        @Override
        public boolean isDone() {
                synchronized (this.sync){
                        return this.isDone;
                }
        }

        @Override
        public R get() throws InterruptedException, ExecutionException {
                synchronized (this.sync){
                        for (;;){
                                if(this.isDone){
                                        if(this.isCancel){
                                                throw new CancellationException();
                                        }else if(this.failure!=null){
                                                throw new ExecutionException(this.failure);
                                        }else if(this.result!=null){
                                                return this.result;
                                        }

                                }
                                this.sync.wait();

                        }

                }
        }

        @Override
        public R get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                long startTime = System.currentTimeMillis();
                long timeoutMillis = TimeUnit.MILLISECONDS.convert(timeout, unit);
                synchronized (this.sync){
                        for (;;){
                                if(this.isDone){
                                        if(this.isCancel){
                                                throw new CancellationException();
                                        }else if(this.failure!=null){
                                                throw new ExecutionException(this.failure);
                                        }else if(this.result!=null){
                                                return this.result;
                                        }
                                }else {
                                        if(System.currentTimeMillis()-startTime>timeoutMillis){
                                                throw new TimeoutException();
                                        }
                                }
                                this.sync.wait(timeoutMillis);
                        }
                }
        }


        protected void notifyHaveResult() {
                this.isDone = true;
                this.sync.notifyAll();
        }
}
