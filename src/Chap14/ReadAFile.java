package Chap14;

/**
 * 2013.04.10
 * Michel
 */
import java.io.*;
public class ReadAFile {
	public static void main(String[] args){
	
		try{
			//File myFile = new File("MyText.txt"); 
			File myFile = new File("Foo.txt");  //配合类WriteAFile使用，效果更佳
			FileReader fileReader = new FileReader(myFile);
			BufferedReader reader = new BufferedReader(fileReader);
			
			String line = null;
			
			while((line = reader.readLine())!=null){
				System.out.println(line);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
