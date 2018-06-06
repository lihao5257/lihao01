package com.lee.demo.shortlink.impl;

import java.util.concurrent.Executors;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalListeners;
import com.google.common.cache.RemovalNotification;
import com.lee.demo.util.CustomerUtil;

public class TempDemo01 {  
    
    // 创建一个监听器  
    private static class MyRemovalListener implements RemovalListener<Integer, Integer> {  
        @Override  
        public void onRemoval(RemovalNotification<Integer, Integer> notification) {  
            String tips = String.format("key=%s,value=%s,reason=%s", notification.getKey(), notification.getValue(), notification.getCause());  
            System.out.println(tips);  
  
            try {  
                // 模拟耗时  
                Thread.sleep(2000);  
                System.out.println("2222222222222222");
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
  
        }  
    }  
  
    public static void main(String[] args) {  
  
    	String path="cache.properties";
    	String abc = CustomerUtil.getSpecFromSetting(path);
    	System.out.println(abc);
    }  
  
}  
