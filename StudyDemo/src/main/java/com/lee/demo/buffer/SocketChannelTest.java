package com.lee.demo.buffer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;


public class SocketChannelTest {

	public static void main(String[] args) throws IOException {

		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.connect(new InetSocketAddress("localhost", 8080));
		
		ByteBuffer byteBuffer = ByteBuffer.wrap("019".getBytes());
		socketChannel.write(byteBuffer);
		
		ByteBuffer readBuffer = ByteBuffer.allocate(1024);
		int num;
		if ((num = socketChannel.read(readBuffer)) > 0) {
			readBuffer.clear();
			byte[] re = new byte[num];
            readBuffer.get(re);

            String result = new String(re, "UTF-8");
            System.out.println("返回值: " + result);
		}
	}

}
