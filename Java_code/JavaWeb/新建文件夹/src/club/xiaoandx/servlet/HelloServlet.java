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
package club.xiaoandx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**  
 * <p> 第一个Servlet类 用于浏览显示欢迎信息 </p> 
 * @ClassName:HelloServlet   
 * @author: WEI.ZHOU
 * @date: 2021-04-03 19:21
 * @since: JDK1.8
 * @version V1.0.0
 */
public class HelloServlet extends HttpServlet{

	/**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */ 
	private static final long serialVersionUID = 3702886841055067409L;
	
	/**   
	 * <p> 执行Get请求 </p></br>
	 * <p>Title: doGet</p> 
	 * @date: 2021-04-03 19:22    
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException   
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)   
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("gbk");
		resp.getWriter().append("<h1>搭建第一个Servlet</h1>");
	}

}
