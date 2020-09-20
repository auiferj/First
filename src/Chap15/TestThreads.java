package Chap15;

/**
 * 2013.04.16
 * Michel
 * 本章练习：排排看
 */
public class TestThreads {
	public static void main(String[] args){
		ThreadOne t1 = new ThreadOne();
		ThreadTwo t2 = new ThreadTwo();
		Thread one = new Thread(t1);
		Thread two = new Thread(t2);
		one.start();
		two.start();
	}
}
