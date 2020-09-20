package Chap15;

/**
 * 2013.04.15
 * Michel
 * 用两个都想把余额更新的线程来展示丢失更新
 */
public class TestSync implements Runnable {
	private int balance;
	
	public void run(){
		for(int i=0;i<50;i++){ 
			increment();
			System.out.println("balance is " + balance);
		}
	}
	
	//public void increment(){
	//synchronized锁住的是存取数据的方法
	public synchronized void increment(){
		int i = balance;
		balance = i + 1;
	}
}
