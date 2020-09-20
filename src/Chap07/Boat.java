package Chap07;

/**
 * 2013.03.26
 * michel
 */
public class Boat {
	private int length;
	public void setlength(int len){
		length = len;
	}
	
	public int getLength(){
		return length;
	}
	
	public void move(){
		System.out.println("drift ");
	}
}
