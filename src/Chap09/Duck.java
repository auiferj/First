package Chap09;

/**
 * 2013.03.27
 * Michel
 */
public class Duck {
	int size;
	
	public Duck(){
		//不带参数时，指定默认值
		size = 27;
	}
	
	public Duck(int duckSize){   //给构造函数加个参数
		//使用参数设定
		System.out.println("Quack");
		
		size = duckSize;
		System.out.println("size is " + size);
	}
}
