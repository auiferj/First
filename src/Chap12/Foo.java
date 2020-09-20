package Chap12;

/**
 * 2013.04.01
 * Michel
 */
public class Foo {
	public static void main(String[] args){
		//从外部类以外的地方初始化内部类
		MyOuter outerObj = new MyOuter();
		MyOuter.MyInner innerObj = outerObj.new MyInner();
	}
}
