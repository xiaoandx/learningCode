package club.xiaoandx.servlet.session.login;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)
				throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String checkCode = request.getParameter("check_code");
			String savedCode = (String) request.getSession().getAttribute(
					"check_code");
			request.getSession().removeAttribute("check_code");
			PrintWriter pw = response.getWriter();
			if (("xiaoandx").equals(username) && ("123").equals(password)
					&& checkCode.equals(savedCode)) {
				User user = new User();
				user.setUsername(username);
				request.getSession().setAttribute("user", user);
				response.sendRedirect("/dome_servlet_Base/indexServlet");
			} else if (checkCode.equals(savedCode)) {
				pw.write("用户名或密码错误，登录失败");
			} else {
				pw.write("验证码错误");
			}
		}	
	public void doPost(HttpServletRequest request, 
                           HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
