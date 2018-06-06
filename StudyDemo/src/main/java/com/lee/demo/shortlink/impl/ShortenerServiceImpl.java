package com.lee.demo.shortlink.impl;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalListeners;
import com.google.common.cache.RemovalNotification;
import com.lee.demo.shortlink.dao.IShortLinkDAO;
import com.lee.demo.shortlink.service.ShortenerServiceI;
import com.lee.demo.util.CustomerUtil;

@Service("service")
public class ShortenerServiceImpl implements ShortenerServiceI {

	private static Logger logger = Logger.getLogger(ShortenerServiceImpl.class.getName());
	
	// cache file path
	public static final String PATH = "cache.properties";
		
	@Resource
	private IShortLinkDAO shortLinkDAO;

	private static class MyRemovalListener implements RemovalListener<String, String> {
		@Override
		public void onRemoval(RemovalNotification<String, String> notification) {
            String info = String.format("key=%s,value=%s,reason=%s", 
            							notification.getKey(), 
            							notification.getValue(), 
            							notification.getCause());  
            System.out.println(info);  
            try {  
                // 模拟耗时  
                Thread.sleep(2000);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
		}

	}

    // create a asynchronous RemovalListener
	// every time removing the key-value will trigger the RemovalListener
	RemovalListener<String, String> async = RemovalListeners.asynchronous(new MyRemovalListener(),
			Executors.newSingleThreadExecutor());

	// create guava cache
	LoadingCache<String, String> cache = CacheBuilder.from(CustomerUtil.getSpecFromSetting(PATH))
			.removalListener(async)
			.build(new CacheLoader<String, String>() {
				public String load(String key) throws Exception {
					logger.info("key is " + key);
					return createExpensiveGraph(key);
				}
			});

	// 定义一个简单的cache，不带load，这样的话，在后面使用时，不能用get方法，只能有getIfPresent方法
	// 因为get方法在内存中找不到对应的value时，回去load方法中创建value值。
	/*Cache<String, String> cache = CacheBuilder.newBuilder().expireAfterWrite(10, TimeUnit.MINUTES).build(); */
	public String createExpensiveGraph(String key) {
		String value = null;
		try {
			value = shortLinkDAO.selectByKey(key);
		} catch (Exception e) {
			// to do
		}
		return value;
	}
	
	@Override
	public String lookup(String key) {
		String cacheValue = null;
		/*
		 * get method 1.retrieve key in the cache 2.if the value of key is not in the
		 * cache,then load method is called. 3.if the value of key is not created in the
		 * load method,then throw Exception
		 * get方法的过程：
		 * 内存查找，没有的话，load方法创建，再没有的话，throw 异常
		 */
		try {
			cacheValue = cache.get(key);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cacheValue;
	}
}
