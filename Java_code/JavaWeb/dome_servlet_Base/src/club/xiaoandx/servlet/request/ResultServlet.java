package club.xiaoandx.servlet.request;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * <p> 转发处理请求本类的数据 </p> 
 * @ClassName:ResultServlet   
 * @author: WEI.ZHOU
 * @date: 2021-04-16 18:48
 * @since: JDK1.8
 * @version V1.0.0
 */
public class ResultServlet extends HttpServlet {
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = -1076254419512761898L;

	/**
	 * <p>Title: doGet</p> 
	 * @date: 2021-04-16 17:20    
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException   
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, 
	 * 		javax.servlet.http.HttpServletResponse)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String name = (String) request.getAttribute("name");
		if (name != null) {
			out.println("信息输入成功  姓名：" + name + "<br>");
		}
	}

	/**
	 * <p>Title: doPost</p> 
	 * @date: 2021-04-16 17:20    
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException   
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, 
	 * 		javax.servlet.http.HttpServletResponse)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
