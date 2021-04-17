package club.xiaoandx.servlet.request;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class RequestForwardServlet extends HttpServlet {
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 2417921871857988120L;
	
	/**
	 * <p>Title: doGet</p> 
	 * @date: 2021-04-16 17:05    
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
		String username = request.getParameter("username");
		request.setAttribute("name", "xiaoandx科技集团");
		//	输入姓名正确转发至成功界面，输入信息错误会重定向到error.jsp
		if(username.equals("周巍")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/resultServlet");
			dispatcher.forward(request, response);
		}else {
			Cookie cookie = new Cookie("name",username);
			response.addCookie(cookie);
			//	设置web全局的数据共享
			// this.getServletContext().setAttribute("name2", "xiaoandx科技集团");
			response.sendRedirect("/dome_servlet_Base/error.jsp");
		}
	}

	/**
	 * <p>Title: doPost</p> 
	 * @date: 2021-04-16 17:05    
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
