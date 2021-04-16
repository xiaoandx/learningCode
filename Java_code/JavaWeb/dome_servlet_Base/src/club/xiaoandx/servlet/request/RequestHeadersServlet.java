package club.xiaoandx.servlet.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.http.*;

public class RequestHeadersServlet extends HttpServlet {
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = -4207498854404584125L;
	
	/**
	 * <p>Title: doGet</p> 
	 * @date: 2021-04-16 16:37    
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
		PrintWriter outPrint = response.getWriter();
		@SuppressWarnings("rawtypes")
		Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = (String) headerNames.nextElement();
			outPrint.print(headerName + " : " + request.getHeader(headerName) + "<br/>");
		}
	}
	
	/**
	 * <p>Title: doPost</p> 
	 * @date: 2021-04-16 16:37    
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
