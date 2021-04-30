 package club.xiaoandx.servlet.session.example01;
 import java.io.IOException;
 import java.util.*;
 import javax.servlet.ServletException;
 import javax.servlet.http.*;
 
 /**
 * <p> 图书购买servlet </p>
 * @ClassName:PurchaseServlet
 * @author: WEI.ZHOU
 * @date: 2021-04-30 16:41
 * @since: JDK1.8
 * @version V1.0.0
 */
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		if (id == null) {
			// 如果id为null，重定向到ListBookServlet页面
			String url = "/dome_servlet_Base/listBookServlet";
			resp.sendRedirect(url);
			return;
		}
		Book book = BookDB.getBook(id);
		HttpSession session = req.getSession();
		List<Book> cart = (List<Book>) session.getAttribute("cart");
		if (cart == null) {
			cart = new ArrayList<Book>();
			session.setAttribute("cart", cart);
		}
		// 非第一次购买
		cart.add(book);
		Cookie cookie = new Cookie("JSESSIONID", session.getId());
		cookie.setMaxAge(60 * 30);
		cookie.setPath("/dome_servlet_Base");
		resp.addCookie(cookie);
		String url = "/dome_servlet_Base/cartServlet";
		String newurl = resp.encodeRedirectURL(url);
		resp.sendRedirect(newurl);

	}
}
