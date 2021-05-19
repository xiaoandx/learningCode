package club.xiaoandx.section7;
import java.io.*;
public class Test2 {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		File file = new File("source/ex1.txt");
		
		FileInputStream fis = new FileInputStream(file);
		byte b[] = new byte[100];
		int x=0;
		while((x=fis.read(b))!=-1){
			System.out.println(x);
		}
		
		System.out.println(new String(b));
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		int y=0;
		while((y=bis.read())!=-1){
			System.out.print((char)y);
		}
		bis.close();

	}

}
