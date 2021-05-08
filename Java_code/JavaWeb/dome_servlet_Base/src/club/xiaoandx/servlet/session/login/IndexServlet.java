package club.xiaoandx.servlet.session.login;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class IndexServlet extends HttpServlet {
public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
	
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			response.getWriter().print(
			"您还没有登录，请<a href='/dome_servlet_Base/login.html'>登录</a>");
		} else {
            response.getWriter().print("您已登录，欢迎你，" + user.getUsername() + "！");
			response.getWriter().print(
					"<a href='/dome_servlet_Base/logoutServlet'>退出</a>");
			
			// 创建Cookie存放Session的标识号
			Cookie cookie = new Cookie("JSESSIONID", session.getId());
			cookie.setMaxAge(60 * 30);
			cookie.setPath("/dome_servlet_Base");
			response.addCookie(cookie);
		}
	}
	public void doPost(HttpServletRequest request, 
                           HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
