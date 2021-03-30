/*
 * Copyright (c) 2021 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and 
 * commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems
 * and consequences.
 * In case of code problems, feedback can be made through the following email address.
 * 
 *                        <xiaoandx@gmail.com>
 */
package club.xiaoandx.section9;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**  
 * <p> TCP  服务端 </p> 
 *
 * @ClassName:TCP_Server   
 * @author: WEI.ZHOU
 * @date: 2021-03-30 18:57
 * @since: JDK1.8
 * @version V1.0.0
 */
public class TCP_Server {

	public static void main(String[] args) throws Exception {
		new TCPServer().listen();
	}

}

/**
 * <p> TCP服务器端 </p> 
 * @ClassName:TCPServer   
 * @author: WEI.ZHOU
 * @date: 2021-03-30 18:58
 * @since: JDK1.8
 * @version V1.0.0
 */
class TCPServer {
	// 定义一个端口号
	private static final int PORT = 7788;  
	
	/**
	 * <p> 创建TCP客户端方法 </p></br>
	 * @Title: listen  
	 * @date: 2021-03-30 18:59
	 * @throws Exception void    
	 * @since: 1.0.0   
	 * @throws
	 */
	public void listen() throws Exception { 
		// 定义一个listen()方法，抛出异常
		@SuppressWarnings("resource")
		ServerSocket serverSocket = new ServerSocket(PORT); 
		// 调用ServerSocket的accept()方法接收数据
		Socket client = serverSocket.accept(); 
		// 获取客户端的输出流
		OutputStream os = client.getOutputStream();
		System.out.println("开始与客户端交互数据");
		// 当客户端连接到服务器端时，向客户端输出数据
		os.write(("我的TCP服务端").getBytes());   
		Thread.sleep(5000);// 模拟执行其他功能占用的时间
		System.out.println("结束与客户端交互数据");
		os.close();
		client.close();
	}
}
