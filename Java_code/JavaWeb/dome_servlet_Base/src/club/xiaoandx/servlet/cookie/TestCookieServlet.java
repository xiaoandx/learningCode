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
package club.xiaoandx.servlet.cookie;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**  
 * <p> cookie测试 </p> 
 * @ClassName:TestCookie   
 * @author: WEI.ZHOU
 * @date: 2021-04-30 15:31
 * @since: JDK1.8
 * @version V1.0.0
 */
public class TestCookieServlet extends HttpServlet{
	
	/**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */ 
	private static final long serialVersionUID = 421430760246901526L;

	/**   
	 * <p>Title: doGet</p> 
	 * @date: 2021-04-30 15:32    
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException   
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)   
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		String lastAccessTime = null;
		Cookie[] cookies = req.getCookies();
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			if ("lastAccess".equals(cookies[i].getName())) {
				lastAccessTime = cookies[i].getValue();
				break;
			}
		}
		if (lastAccessTime == null) {
			resp.getWriter().print("您是首次访问本站！！！");
		} else {
			resp.getWriter().print("您上次的访问时间是： " + lastAccessTime);
		}
		String currentTime = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss")
				.format(new Date());
		Cookie cookie = new Cookie("lastAccess", currentTime);
		resp.addCookie(cookie);
	}
	
	/**   
	 * <p>Title: doPost</p> 
	 * @date: 2021-04-30 15:32    
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException   
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)   
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
