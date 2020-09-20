package Chap04;

/**
 * 2013.03.21
 * Michel
 */
public class PoorDog {
	//实例变量是声明在类中而不是方法中
	private int size;
	private String name;
	
	public int getSize(){
		/*
		//局部变量是声明在方法中
		int x;
		局部变量在使用前必须初始化
		//return x;  //error: The local variable x may not have been initialized
		*/
		return size;
	}
	
	public String getName(){ 
		return name;
	}
}
