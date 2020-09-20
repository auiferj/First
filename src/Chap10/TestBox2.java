package Chap10;

/**
 * 2013.03.28
 * Michel
 */
public class TestBox2 {
	 
	public static void main(String[] args) {
		//将String类型转换成数字类型
		String s = "2";
		int x = Integer.parseInt(s);
		double b = Double.parseDouble("420.24");
		
		//将数字转换成String
		double d = 42.5;
		String doubleString = "" + d; //"+"这个操作符是Java中唯一重载过得运算符
		
		double d2 = 42.5;
		String doubleString2 = Double.toString(d);  //Double类的静态方法toString
		
		
	}

}
