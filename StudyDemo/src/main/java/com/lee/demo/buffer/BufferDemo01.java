package com.lee.demo.buffer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.channels.FileChannel;


public class BufferDemo01 {
	
	public static void main(String args[]) throws FileNotFoundException {
		System.out.println("");
		Buffer buffer2 = ByteBuffer.allocate(1024);
		Buffer buffer3 = IntBuffer.allocate(1024);
		Buffer buffer4 = LongBuffer.allocate(1024);
		FileInputStream inputStream = new FileInputStream(new File("/data.txt"));
		FileChannel fileChannel = inputStream.getChannel();
		
		
	}
}
