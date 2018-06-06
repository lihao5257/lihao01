package com.lee.demo.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

import org.junit.experimental.theories.Theories;
import org.springframework.core.io.Resource;

/*
 * util class 
 * @author lee
 */
public class CustomerUtil {

	/*
	 * get specified guava cache item from setting file 
	 * @param path setting file path
	 * @return converted String 
	 *         format 
	 *         maximumSize=10000,expireAfterWrite=10m
	 */
	@SuppressWarnings("finally")
	public static String getSpecFromSetting(String path){
		Properties prop = new Properties();    
		String spec = "";
        try{
            //读取属性文件a.properties
        	InputStream in = CustomerUtil.class.getClassLoader().getResourceAsStream(path);
            prop.load(in);     //加载属性列表
            Iterator<String> it=prop.stringPropertyNames().iterator();
            StringBuilder sb = new StringBuilder();
            while(it.hasNext()){
                String key=it.next();
                sb.append(key + "=" + prop.getProperty(key));
                sb.append(",");
            }
            in.close();
            spec = sb.deleteCharAt(sb.length()-1).toString();
        } catch(Exception e){
        	e.printStackTrace();
        } finally {
        	return spec;
        }
	}
}
