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
import java.net.InetAddress;

/**  
 * <p> UDP 发送端程序 </p> 
 *
 * @ClassName:UDP_Sender   
 * @author: WEI.ZHOU
 * @date: 2021-03-28 16:46
 * @since: JDK1.8
 * @version V1.0.0
 */
public class UDP_Sender {
	public static void main(String[] args) throws Exception {
		// 创建一个DatagramSocket对象
		DatagramSocket ds = new DatagramSocket(3000);
		// 要发送的数据
		String str = "xiaoandx"; 
		//将定义的字符串转为字节数组
		byte[] arr = str.getBytes(); 
         //创建一个要发送的数据包，数据包包括发送的数据，
         //数据的长度，接收端的IP地址以及端口号
	    DatagramPacket dp = new DatagramPacket(arr, arr.length,
        InetAddress.getByName("localhost"), 8954);
		System.out.println("发送信息");
		// 发送数据
		ds.send(dp); 
		// 释放资源
		ds.close(); 
	}
}
