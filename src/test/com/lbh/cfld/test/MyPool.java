package com.lbh.cfld.test;/*
 */

import java.util.LinkedList;

public class MyPool {
    LinkedList<Runnable> tasks =  new LinkedList<Runnable>();
    public MyPool(){
        for(int i = 0 ;i<10;i++){

        }

    }
    public  void add(Runnable r){
        synchronized (tasks)
    }
    class TaskConsumeThread extends Thread{
        Runnable runnable;
        public void run(){
            while (true){
                synchronized (tasks){
                    while (tasks.isEmpty()){
                        try {
                            tasks.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    runnable = tasks.removeLast();
                    tasks.notifyAll();
                }
                runnable.run();
            }
        }
    }
}
