package club.xiaoandx.servlet.session.example01;

import java.io.Serializable;

/**
 * <p> 图书实体 </p> 
 * @ClassName:Book   
 * @author: WEI.ZHOU
 * @date: 2021-04-30 16:34
 * @since: JDK1.8
 * @version V1.0.0
 */
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;

	public Book() {
	}

	public Book(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
