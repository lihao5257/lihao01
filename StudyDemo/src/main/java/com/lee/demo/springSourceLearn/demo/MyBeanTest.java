package com.lee.demo.springSourceLearn.demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class MyBeanTest {

	public static void main(String srgas[] ){
		/*		@SuppressWarnings("deprecation")
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beaFactoryTest.xml"));
		MyBean bean = (MyBean)bf.getBean("myTestBean");
		System.out.println(bean.getTestStr());*/
		
		ApplicationContext bf = new ClassPathXmlApplicationContext("beaFactoryTest.xml");
		MyBean bean = (MyBean)bf.getBean("myTestBean");
		System.out.println(bean.getTestStr());
		
		System.out.println("--------------------------------");

		String envStr2 = System.getenv("path");
		System.out.println(envStr2);
		System.out.println("--------------------------------");
	}
}
