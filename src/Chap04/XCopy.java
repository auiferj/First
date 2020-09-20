package Chap04;

/**
 * 2013.03.21
 * Michel
 */
public class XCopy {
	public static void main(String[] args){
		int orig = 42;
		XCopy x = new XCopy();
		int y = x.go(orig);       //84
		
		System.out.println(orig + " " + y);  //42 按值传递
	}
	
	int go(int arg){
		 arg = arg * 2;
		 return arg;
	}
}
