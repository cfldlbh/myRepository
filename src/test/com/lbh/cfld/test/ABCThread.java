package com.lbh.cfld.test;/*
 */

public class ABCThread implements Runnable {
    private Object suffix;
    private Object prefix;
    private String name;
    public void run() {
        int i = 10;
        while (true){
            if(i==0){
                break;
            }
            synchronized (prefix){
                synchronized (suffix){
                    System.out.println(name);
                    suffix.notify();
                    i--;
                }
                try {
                    prefix.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public ABCThread(Object suffix,Object prefix,String name){
        this.suffix = suffix;
        this.prefix = prefix;
        this.name = name;
    }
}
