package com.lee.demo.springSourceLearn.demo;

public class ClassLoaderTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        ClassLoader cl = Test.class.getClassLoader();

        System.out.println("ClassLoader is:"+cl.toString());

        System.out.println(Thread.currentThread().getContextClassLoader().toString());
        
        String aa = System.getProperty("user.dir" );
        
        System.out.println(aa);
/*        cl = int.class.getClassLoader();

        System.out.println("ClassLoader is:"+cl.toString());*/

    }

}