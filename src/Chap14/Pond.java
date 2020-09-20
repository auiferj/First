package Chap14;

/**
 * 2013.04.08
 * Michel
 */
import java.io.*;
public class Pond implements Serializable {
	
	private Duck duck = new Duck();
		
	public static void main(String[] args) { 
		Pond myPond = new Pond();
		try{
			FileOutputStream fs = new FileOutputStream("Pond.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			
			os.writeObject(myPond);  //将myPond序列化的同时Duck也会被序列化
			os.close();
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}