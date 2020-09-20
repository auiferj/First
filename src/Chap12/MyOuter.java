package Chap12;

/**
 * 2013.04.01
 * Michel
 */
public class MyOuter {
	private int x;
	
	MyInner inner = new MyInner(); //外部类初始化内部类
	public void doStuff(){
		inner.go();
	}
	
	class MyInner{
		void go(){
			x = 42;
		}
	}
}
