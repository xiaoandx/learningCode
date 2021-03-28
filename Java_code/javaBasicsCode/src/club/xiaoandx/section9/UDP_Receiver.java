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

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**  
 * <p> UDP 通信基础学习 </p> 
 *	UDP通信接收端程序
 * @ClassName:UDP_Receiver   
 * @author: WEI.ZHOU
 * @date: 2021-03-28 16:44
 * @since: JDK1.8
 * @version V1.0.0
 */
public class UDP_Receiver {
	public static void main(String[] args) throws Exception {
		// 创建一个字节数组，用于接收数据
		byte[] buf = new byte[1024]; 
         // 定义一个DatagramSocket对象，监听的端口号为8954
		DatagramSocket ds = new DatagramSocket(8954);
         // 定义一个DatagramPacket对象，用于接收数据
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		System.out.println("等待接收数据");
		ds.receive(dp); // 等待接收数据，如果没有数据则会阻塞
         // 调用DatagramPacket的方法获得接收到的信息
		
         //包括数据的内容、长度、发送的IP地址和端口号
		String str = new String(dp.getData(), 0, dp.getLength()) +
         "from "+ dp.getAddress().getHostAddress() + ":" + dp.getPort();
		System.out.println(str); // 打印接收到的信息
		ds.close();// 释放资源
	}
}
