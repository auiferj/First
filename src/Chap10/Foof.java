package Chap10;

/**
 * 2013.03.28
 * Michel
 * 非静态final变量
 */

public class Foof {
	final int size = 3;
	final int whuffie;
	
	Foof(){
		whuffie = 42;      //whuffie初始化
		//whuffie = 42;    //--> error  whuffie不能改变
	}
	
	void doStuff(final int x){
		//x=8; //--> error  不能改变x
	}
	
	void doMore(){
		final int z = 7;
		//不能改变z
	}
}
