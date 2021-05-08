package club.xiaoandx.servlet.session.login;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class LogoutServlet extends HttpServlet {
public void doGet(HttpServletRequest request, 
                      HttpServletResponse response)
		throws ServletException, IOException {
     // 将Session对象中的User对象移除
		request.getSession().removeAttribute("user");
		response.sendRedirect("/dome_servlet_Base/indexServlet");
	}
	public void doPost(HttpServletRequest request, 
       HttpServletResponse response)throws ServletException, IOException {
		doGet(request, response);
	}
}
