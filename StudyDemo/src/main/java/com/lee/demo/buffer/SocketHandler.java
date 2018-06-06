package com.lee.demo.buffer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

import javax.naming.BinaryRefAddr;

import org.apache.commons.io.IOUtils;


public class SocketHandler implements Runnable {

	private SocketChannel socketChannel;
	public SocketHandler(SocketChannel socketChannel) {
		this.socketChannel = socketChannel;
	}
	@Override
	public void run() {

		ByteBuffer buffer = ByteBuffer.allocate(1024);
		try {
			int num;
			while ((num = socketChannel.read(buffer)) > 0) {
				buffer.flip();
				byte[] bytes = new byte[num];
				buffer.get(bytes);
				String re = new String(bytes,"UTF-8");
				System.out.println("received request：" + re);
				
				ByteBuffer writeBuffer = ByteBuffer.wrap(("我已经收到你的请求，你的请求内容是：" + re).getBytes());
                socketChannel.write(writeBuffer);

                buffer.clear();
			}
		}catch (IOException e) {
			System.out.println("came into IOException ");
			
		} finally {
			//IOUtils.closeQuietly(socketChannel);
		}
	}

}
