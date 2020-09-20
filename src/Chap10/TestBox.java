package Chap10;

/**
 * 2013.03.28
 * Michel
 */
public class TestBox {
	
	Integer i;    //Integer类
	int j;
	
	public static void main(String[] args) {
		TestBox t = new TestBox();
		
		t.i = 1;   //若此处i不初始化，则i为null，后面i赋值给j会出错
		t.go();
	}
	
	public void go(){
		j=i;
		System.out.println(i);
		System.out.println(j);
	}

}
