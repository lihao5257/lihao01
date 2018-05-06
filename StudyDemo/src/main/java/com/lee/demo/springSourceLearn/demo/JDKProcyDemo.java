package com.lee.demo.springSourceLearn.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProcyDemo {
	 
    interface DoSomething {
        void originalMethod(String s);
    }
 
    static class Original implements DoSomething {
        public void originalMethod(String s) {
            System.out.println(s);
        }
    }
 
    static class Handler implements InvocationHandler {
        private final DoSomething original;
 
        public Handler(DoSomething original) {
            this.original = original;
        }
 
        @Override
        public Object invoke(Object proxy, Method method, Object[] args)
                throws IllegalAccessException, IllegalArgumentException,
                InvocationTargetException {
            System.out.println("BEFORE");
            method.invoke(original, args);
            System.out.println("AFTER");
            return null;
        }
    }
 
    public static void main(String[] args){
    	System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true"); 
        Original original = new Original();
        Handler handler = new Handler(original);
        DoSomething f = (DoSomething) Proxy.newProxyInstance(DoSomething.class.getClassLoader(),
                new Class[] { DoSomething.class },
                handler);
        System.out.println(f.getClass().getName());
        System.out.println(f.getClass().getInterfaces());
        f.originalMethod("Hallo");
    }
 
}
