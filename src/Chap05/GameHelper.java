package Chap05;

/**
 * 2013.03.21
 * Michel
 * 用于接收用户输入
 */
import java.io.*;
public class GameHelper {
	public String getUserInput(String prompt){
		String inputLine = null;
		System.out.print(prompt + "  ");
		try{
			BufferedReader is = new BufferedReader(
			new InputStreamReader(System.in));
			inputLine = is.readLine();
			if(inputLine.length() == 0){
				return null;
			}
		} catch (IOException e) {
			System.out.println("IOException: " + e);
		} 
		return inputLine;
	}
}
