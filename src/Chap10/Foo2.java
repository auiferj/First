package Chap10;

/**
 * 2013.03.28
 * Michel
 * 谁是合法的？
 */
public class Foo2 {
	//Foo1
	static int x1;   //未初始化，默认值0
	public void go1(){
		//合法，非静态方法可以存取静态变量
		System.out.println(x1);
	}
	
	//Foo2
	int x2;
	public static void go2(){ 
		//System.out.println(x2);  //error 静态方法不能存取非静态变量
	}
	
	//Foo3
	//final int x3;     //-->error
	final int x3 = 11;  //final变量必须初始化
	public void go3(){
		//非静态方法可以调用final变量
		System.out.println(x3);
	}
	 
	//Foo4
	static final int x4 = 12;
	public void go4(){
		//合法。非静态方法可以调用静态final变量（常量）
		System.out.println(x4);
	}
	
	//Foo5
	static final int x5 = 13;
	public void go5(final int x5){
		System.out.println(x5);    //此处X5为方法传入参数
	}
	
	//Foo6
	int x6 = 14;
	public static void go6(final int x6){
		//合法
		System.out.println(x6);
	}
	
	
	//test
	public static void main(String[] args){
		Foo2 f = new Foo2();
		f.go1();
		f.go2();
		f.go3();
		f.go4();
		f.go5(23);
		f.go6(24);
	}
}
