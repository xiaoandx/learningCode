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

import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

/**  
 * <p> TCP 客户端 </p> 
 *
 * @ClassName:TCP_Client   
 * @author: WEI.ZHOU
 * @date: 2021-03-30 19:01
 * @since: JDK1.8
 * @version V1.0.0
 */
public class TCP_Client {
	public static void main(String[] args) throws Exception {
		new TCPClient().connect();
	}

}

/**
 * <p> TCP客户端 </p> 
 * @ClassName:TCPClient   
 * @author: WEI.ZHOU
 * @date: 2021-03-30 19:01
 * @since: JDK1.8
 * @version V1.0.0
 */
class TCPClient {
	// 服务器端的端口号
	private static final int PORT = 7788; 
	
	/**
	 * <p> 创建一个客户端用于连接TCP服务端 </p></br>
	 * @Title: connect  
	 * @date: 2021-03-30 19:02
	 * @throws Exception void    
	 * @since: 1.0.0   
	 * @throws
	 */
	public void connect() throws Exception {
		//创建一个Socket并连接到给出地址和端口号的计算机
		Socket client = new Socket(InetAddress.getLocalHost(), PORT);
		// 得到接收数据的流
		InputStream is = client.getInputStream();   
		// 定义1024个字节数组的缓冲区
		byte[] buf = new byte[1024];   
		// 将数据读到缓冲区中
		int len = is.read(buf);
		// 将缓冲区中的数据输出
		System.out.println(new String(buf, 0, len));
		// 关闭Socket对象,释放资源
		client.close();   
	}
}
