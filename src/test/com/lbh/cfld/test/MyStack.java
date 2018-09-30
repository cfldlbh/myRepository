package com.lbh.cfld.test;/*
 */


import java.util.LinkedList;
import java.util.Stack;

public class MyStack extends Stack {
    public static LinkedList list  = new LinkedList<hero>();
    public void push(hero hero){
        list.addLast(hero);
    }
    public  hero pull(){
        return (hero) list.removeLast();
    }
}
