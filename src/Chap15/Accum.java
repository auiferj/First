package Chap15;

/**
 * 2013.04.16
 * Michel
 * 本章练习：排排看
 */
public class Accum {
	private static Accum a = new Accum();
	private int counter = 0;
	
	//私用的构造函数
	private Accum(){}  
	
	public static Accum getAccum(){
		return a;
	}
	
	public void updateCounter(int add){
		counter+=add;
	}
	
	public int getCount(){
		return counter;
	} 
}
