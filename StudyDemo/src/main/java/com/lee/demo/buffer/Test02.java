package com.lee.demo.buffer;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte[] bytes = new byte[100];
		try {
			String re = new String(bytes,"UTF-8");
			System.out.println("received request：" + re);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block

			System.out.println("fail");
			e.printStackTrace();
		}
		System.out.println("success");
	}

}
