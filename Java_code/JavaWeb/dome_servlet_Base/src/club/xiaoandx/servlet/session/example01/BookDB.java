package club.xiaoandx.servlet.session.example01;
import java.util.Collection;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p> 本地图书数据操作 </p> 
 * @ClassName:BookDB   
 * @author: WEI.ZHOU
 * @date: 2021-04-30 16:35
 * @since: JDK1.8
 * @version V1.0.0
 */
public class BookDB {
	private static Map<String, Book> books = new LinkedHashMap<String, Book>();
	
	static {
		books.put("1", new Book("1", "javaweb开发"));
		books.put("2", new Book("2", "jdbc开发"));
		books.put("3", new Book("3", "java基础"));
		books.put("4", new Book("4", "struts开发"));
		books.put("5", new Book("5", "spring开发"));
	}
	
	/**
	 * <p> 获取所有的图书 </p></br>
	 * @Title: getAll  
	 * @date: 2021-04-30 16:35
	 * @return Collection<Book>    
	 * @since: 1.0.0   
	 */
	public static Collection<Book> getAll() {
		return books.values();
	}

	/**
	 * <p> 获取一本图书,通过图书编号 </p></br>
	 * @Title: getBook  
	 * @date: 2021-04-30 16:36
	 * @param id
	 * @return Book    
	 * @since: 1.0.0   
	 */
	public static Book getBook(String id) {
		return books.get(id);
	}
}
