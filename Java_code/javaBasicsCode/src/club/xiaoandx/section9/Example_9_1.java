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

import java.io.IOException;
import java.net.InetAddress;

/**  
 * <p> Java 网络编程 InetAddress </p> 
 *	1. InetAddress类中提供常用的网络方法
 * @ClassName:Example   
 * @author: WEI.ZHOU
 * @date: 2021-03-28 16:39
 * @since: JDK1.8
 * @version V1.0.0
 */
public class Example_9_1 {
	public static void main(String[] args) throws IOException {
		InetAddress localAddress = InetAddress.getLocalHost();
		   InetAddress remoteAddress = InetAddress. getByName("www.xiaoandx.club");
		   System.out.println("本机的IP地址：" + localAddress.getHostAddress());
		   System.out.println("xiaoandx 的IP地址：" + remoteAddress.getHostAddress());
		   System.out.println("3秒是否可达：" + remoteAddress.isReachable(5000));
		   System.out.println("xiaoandx 的主机名（域名）为：" + remoteAddress.getHostName());
	}
}
