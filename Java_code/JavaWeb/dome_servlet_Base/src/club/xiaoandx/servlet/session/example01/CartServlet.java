package club.xiaoandx.servlet.session.example01;
import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 * <p> 购买图书的购物车  </p> 
 * @ClassName:CartServlet   
 * @author: WEI.ZHOU
 * @date: 2021-04-30 16:36
 * @since: JDK1.8
 * @version V1.0.0
 */
public class CartServlet extends HttpServlet {
	/**   
	 * @Fields serialVersionUID    
	 */ 
	private static final long serialVersionUID = 5407528900423398962L;

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		List<Book> cart = null;
		boolean purFlag = true;
		HttpSession session = req.getSession(false);
		
		if (session == null) {
			purFlag = false;
		} else {
			cart = (List<Book>) session.getAttribute("cart");
			if (cart == null) {
				purFlag = false;
			}
		}
		/*
		 * 如果purFlag为false，表明用户没有购买图书 重定向到ListServlet页面
		 */
		if (!purFlag) {
			out.write("对不起！您还没有购买任何商品！<br>");
		} else {
			out.write("您购买的图书有：<br>");
			for (Book book : cart) {
				out.write(book.getName() + "<br>");
			}
		}
	}
}
