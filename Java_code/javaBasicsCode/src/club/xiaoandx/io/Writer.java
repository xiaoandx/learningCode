/*
 * Copyright (c) 2021 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and 
 * commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems
 * and consequences.
 * In case of code problems, feedback can be made through the following email address.
 * 
 *                        <xiaoandx@gmail.com>
 */
package club.xiaoandx.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**  
 * <p> 字符流输出 学习 </p> 
 * @ClassName:Writer   
 * @author: WEI.ZHOU
 * @date: 2021-05-26 10:31
 * @since: JDK1.8
 * @version V1.0.0
 */
public class Writer {
	
	/**
	 * <p> 字符流 FileWriter 输出 </p></br>
	 * @Title: fileWriter  
	 * @date: 2021-05-26 10:33 void    
	 * @since: 1.0.0   
	 */
	public static void fileWriter(File file) {
		String writerConter = "xiaoandx go go go";
		FileWriter writer = null;
		try {
			writer = new FileWriter(file);
			writer.write(writerConter);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				writer.flush();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * <p> 字符流读写件 bufferedWriter</p></br>
	 * @Title: bufferedWriter  
	 * @date: 2021-05-26 11:11
	 * @param file void    
	 * @since: 1.0.0   
	 */
	public static void bufferedWriter(File file) {
		String writerConter = "你好啊 周巍";
		BufferedWriter bufferedWriter = null;
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(file));
			bufferedWriter.write(writerConter);
			bufferedWriter.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * <p> 字符流写 printWriter </p></br>
	 * @Title: printWriter  
	 * @date: 2021-05-26 11:11
	 * @param file void    
	 * @since: 1.0.0   
	 */
	public static void printWriter(File file) {
		String writerConter = "printWriter";
		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
		printWriter.write(writerConter);
		printWriter.close();
	}
	
	/**
	 * <p> 字符流读取文件内容 fileReader </p></br>
	 * @Title: fileReader  
	 * @date: 2021-05-26 10:47
	 * @param file void    
	 * @since: 1.0.0   
	 */
	public static void fileReader(File file) {
		FileReader fr = null;
		char[] a = new char[50];
		try {
			fr = new FileReader(file);
			fr.read(a);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
        for (char c : a) {
        	System.out.print(c);
        }
        
        try {
			fr.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	/**
	 * <p> 字符流Buffered读取 </p></br>
	 * @Title: bufferedReader  
	 * @date: 2021-05-26 11:03
	 * @param file void    
	 * @since: 1.0.0   
	 */
	public static void bufferedReader(File file) {
		BufferedReader bufferedReader = null;
        StringBuffer sb;
        try {
        	bufferedReader = new BufferedReader(new FileReader(file));
			while (bufferedReader.ready()){
			    sb = (new StringBuffer(bufferedReader.readLine()));
			    System.out.println(sb);
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
        try {
			bufferedReader.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	/**
	 * <p> Scanner 读取文件内容 </p></br>
	 * @Title: scanner  
	 * @date: 2021-05-26 11:15
	 * @param file void    
	 * @since: 1.0.0   
	 */
	public static void scanner(File file) {
		Scanner s = null;   
        try {   
            s = new Scanner(new BufferedReader(new FileReader(file)));   
            while (s.hasNext()) {   
                System.out.println(s.next());   
            }   
        } catch (FileNotFoundException e) {
        	System.err.println(e.getMessage());
		} finally {   
            if (s != null) {   
                s.close();   
            }   
        }   
	}
	
	public static void main(String[] args) {
		String filePathUrl1 = "files/io/test1.txt";
		File file1 = new File(filePathUrl1);
		fileWriter(file1);
		fileReader(file1);
		
		String filePathUrl2 = "files/io/test2.txt";
		File file2 = new File(filePathUrl2);
		bufferedWriter(file2);
		bufferedReader(file2);
		
		String filePathUrl3 = "files/io/test3.txt";
		File file3 = new File(filePathUrl3);
		printWriter(file3);
		scanner(file3);
	}
}
