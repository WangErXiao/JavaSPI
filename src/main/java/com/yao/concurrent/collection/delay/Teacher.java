package com.yao.concurrent.collection.delay;

import java.util.concurrent.DelayQueue;

/**
 * Created by yao on 15/8/6.
 */
public class Teacher implements Runnable {

    private DelayQueue<Student>students;

    public Teacher(DelayQueue<Student> students){
        this.students = students;
    }

    @Override
    public void run() {
        try {
            System.out.println(" test start");
            while(!Thread.interrupted()){
                students.take().run();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
