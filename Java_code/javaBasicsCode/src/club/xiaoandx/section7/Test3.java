package club.xiaoandx.section7;
import java.io.*;
import java.util.Scanner;
public class Test3 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("source/ex2.txt");
		
		PrintWriter pw = new PrintWriter(file);
		pw.print("字符流写内容测试");
		pw.print(546);
		pw.print(" ");
		pw.print(true);
		
		pw.close();
		
		/*Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		long b = in.nextLong();
		short c = in.nextShort();
		float d = in.nextFloat();
		double e = in.nextDouble();
		boolean f = in.nextBoolean();*/
		
		Scanner in = new Scanner(file);
		/*String st  = in.next();//next()���������ո����Ϊֹ
		int m = in.nextInt();
		boolean b = in.nextBoolean();
		System.out.println(st);
		System.out.println(m);
		System.out.println(b);*/
		
		String s = in.nextLine();//遇到回车结束读取ֹ
		System.out.println(s);
		in.close();

	}

}
