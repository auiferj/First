package Chap10;

/**
 * 2013.03.27
 * Michel
 */
public class Duck {
	private int size;
	
	//此静态变量duckCount只会在类第一次载入的时候被初始化
	//每个Duck对象都有自己的size变量，但是所有Duck实例共有一份duckCount变量
	private static int duckCount = 0;
	
	public Duck(){
		duckCount++;
	}
	
	public void setSize(int s){
		size = s;
	}
	
	public int getSize(){
		return size;
	}
}