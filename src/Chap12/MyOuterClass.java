package Chap12;

/**
 * 2013.04.01
 * Michel
 */
public class MyOuterClass {   //外部类
	
	private int x;
	
	class MuInnerClass{      //内部类
		void go(){
			x = 42;
		}
	}
}
