package club.xiaoandx.section7;
import java.io.*;
public class Test1 {

	public static void main(String[] args) throws IOException {
		
		File file = new File("source/ex1.txt");
		
		String s1 = "文字内容";
		
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(s1.getBytes());
		fos.close();
				
		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(file,true));
		byte b[]={97,98,65,69};
		bos.write(b);
		bos.close();
		
		System.out.println(file.getName());
		System.out.println(file.getAbsolutePath());
	}

}
