package Chap14;

/**
 * 2013.04.10
 * Michel
 * 写字符串文本
 */
import java.io.*;
public class WriteAFile {
	public static void main(String[] args){
		try{
			FileWriter writer = new FileWriter("Foo.txt");
			writer.write("hello foo!");
			writer.close();
		} catch(IOException ex){
			ex.printStackTrace();
		}
	}
}
