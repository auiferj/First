package Chap04;

/**
 * 2013.03.20
 * Michel
 */
public class DogTestDrive {
	public static void main(String[] args){
		Dog one = new Dog();
		one.size = 70;
		Dog two = new Dog();
		two.size = 8;
		Dog three = new Dog();
		three.size = 35;
		
		one.bark();
		two.bark();
		three.bark();
		
		//JAVA是通过值传递的，也就是说通过拷贝传递
		//方法无法改变调用方法所传入的参数
		int x = 3;
		test(x);
		System.out.println(x);   //print 3
	}
	
	static void test(int x){
		x++;
	}
}
