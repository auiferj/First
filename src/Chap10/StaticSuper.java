package Chap10;

/**
 * 2013.03.28
 * Michel
 */
public class StaticSuper {
	static {
		System.out.println("super static block");
	}
	
	StaticSuper() {
		System.out.println("super constructor");
	}
}
