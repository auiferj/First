package Chap02;

//2013.03.19
//Michel
public class Player {
	int number=0;  //要猜的数字
	
	public void guess(){
		number=(int)(Math.random()*10);
		System.out.println("I'm guessing "+number);
	}
}
