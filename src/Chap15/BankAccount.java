package Chap15;

/**
 * 2013.04.15
 * Michel
 * 杰纶与沛晨的范例
 */
public class BankAccount {
	private int balance = 100;  //假设账户一开始有100元
	public int getBalance(){
		return balance;
	}
	public void withdraw(int amount){
		balance = balance - amount;
	}
}
