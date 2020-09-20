package Chap16;

/**
 * 2013.04.17
 * Michel
 * 本章节最后习题
 */
public class Mountain {
	String name;
	int height;
	
	Mountain(String n,int h){
		name = n;
		height = h;
	}
	
	public String toString(){
		return name + " " + height;
	}
}
