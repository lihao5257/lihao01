package com.lee.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	public static void main(String[] args) {  
        // 停车场
        ExecutorService exec = Executors.newCachedThreadPool();  
        // 只有五个车位
        final Semaphore semp = new Semaphore(5);  
        // 模拟20辆车进入 
        for (int index = 0; index < 20; index++) {
            final int NO = index; 
            exec.execute(() -> {
            	try {  
                    // 获取进入许可 
                    semp.acquire();  
                    System.out.println("Car No: " + NO);  
                    Thread.sleep((long) (Math.random() * 10000));  
                    // 出去后，释放 ，如果屏蔽下面的语句，则在控制台只能打印5条记录，之后线程一直阻塞
                    semp.release();  
                } catch (InterruptedException e) {  
                }  
            });  
        }  
        // 退出线程池 
        exec.shutdown();  
    }  
}
