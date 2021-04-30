package club.xiaoandx.servlet.session.example01;
import java.io.*;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 * <p> 查看所有的图书列表 </p> 
 * @ClassName:ListBookServlet   
 * @author: WEI.ZHOU
 * @date: 2021-04-30 16:39
 * @since: JDK1.8
 * @version V1.0.0
 */
public class ListBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		Collection<Book> books = BookDB.getAll();
		out.write("本站提供的图书有：<br>");
		for (Book book : books) {
			String url = "/dome_servlet_Base/purchaseServlet?id=" + book.getId();
			String newUrl = resp.encodeRedirectURL(url);
			out.write(book.getName() + "<a href='" + newUrl + "'>点击购买</a><br>");
		}
	}
}
