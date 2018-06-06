package com.lee.demo.test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lee.demo.shortlink.service.ShortenerServiceI;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
public class TestMybatis {  
    private static Logger logger = Logger.getLogger(TestMybatis.class);  
    @Autowired 
    private ShortenerServiceI sShortenerService;  
  
    @Test  
    public void test1() {  
        String  original_url = sShortenerService.lookup("200987");  
        // System.out.println(user.getUserName());  
        // logger.info("值："+user.getUserName());  
        System.out.println(original_url);
        logger.info(original_url);  
    }
}  
