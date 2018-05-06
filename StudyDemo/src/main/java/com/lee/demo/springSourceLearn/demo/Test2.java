package com.lee.demo.springSourceLearn.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test2 {

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition=lock.newCondition();
    public void testMethod() {
        
        try {
            lock.lock();
            System.out.println("开始wait");
            condition.await();
            System.out.println("begin");
            for (int i = 0; i < 5; i++) {
                System.out.println("ThreadName=" + Thread.currentThread().getName()
                        + (" " + (i + 1)));
            }
        } catch (InterruptedException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        finally
        {
            lock.unlock();
        }
    }
    
    public void releaseMethod(){
    	try {
    		lock.lock();
    	condition.signal();
    	}
    	finally
        {
            lock.unlock();
        }
    }

}