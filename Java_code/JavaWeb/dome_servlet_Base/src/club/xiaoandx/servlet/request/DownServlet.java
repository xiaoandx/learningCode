package club.xiaoandx.servlet.request;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class DownServlet extends HttpServlet {
	/**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */ 
	private static final long serialVersionUID = 5287126407710339324L;
	
	/**
	 * <p>Title: doGet</p> 
	 * @date: 2021-04-16 16:50    
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
		String refererURL = request.getHeader("referer");
		String sitePart = "http://" + request.getServerName();
		if (refererURL != null && refererURL.startsWith(sitePart)) {
			out.println("文件正在下载中......");
		} else {
			/**
			 * 请求转发RequestDispatcher forward()
			 */
			RequestDispatcher rd = request.getRequestDispatcher("/download.html");
			rd.forward(request, response);
		}
	}
	
	/**
	 * <p>Title: doPost</p> 
	 * @date: 2021-04-16 16:50    
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
