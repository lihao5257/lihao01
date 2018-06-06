package com.lee.demo.buffer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;


public class SelectorServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Selector selector = Selector.open();
		
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.socket().bind(new InetSocketAddress(8080));
		
		serverSocketChannel.configureBlocking(false);
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		
		while (true) {
			int readyChannels = selector.select();
			if (readyChannels == 0) {
				continue;
			}
			Set<SelectionKey> readKeys = selector.selectedKeys();
			Iterator<SelectionKey> iterator = readKeys.iterator();
			while (iterator.hasNext()) {
				SelectionKey key = iterator.next();
				iterator.remove();
				
				if (key.isAcceptable()) {
					SocketChannel socketChannel = serverSocketChannel.accept();
					socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
				} else if (key.isReadable()){
					SocketChannel socketChannel = (SocketChannel) key.channel(); 
					ByteBuffer readBuffer = ByteBuffer.allocate(1024);
					int num = socketChannel.read(readBuffer);
					if (num > 0) {
                        // 处理进来的数据...
                        System.out.println("收到数据：" + new String(readBuffer.array()).trim());
                        ByteBuffer buffer = ByteBuffer.wrap("返回给客户端的数据...".getBytes());
                        socketChannel.write(buffer);
                    } else if (num == -1) {
                        // -1 代表连接已经关闭
                        socketChannel.close();
                    }
					
				}
				
			}
			
			
		}
	}

}
