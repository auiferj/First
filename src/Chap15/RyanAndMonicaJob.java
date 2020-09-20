package Chap15;

/**
 * 2013.04.15
 * Michel
 * 杰纶与沛晨的范例
 */
public class RyanAndMonicaJob implements Runnable {
	//只有一个RyanAndMonicaJob的实例，代表只有一个共享的账户
	private BankAccount account = new BankAccount();
	
	public static void main(String[] args){
		RyanAndMonicaJob theJob = new RyanAndMonicaJob();
		Thread one = new Thread(theJob);
		Thread two = new Thread(theJob);
		one.setName("Ryan");
		two.setName("Monica");
		one.start();
		two.start();
	}
	
	public void run(){
		for(int x=0;x<10;x++){
			makeWithdrawal(10);
			if(account.getBalance()<0){
				System.out.println("Overdrawn!");
			}
		}
	}
	
	//检查账户余额。如果透支就列出信息，不然就去睡一会儿，然后醒来完成提款操作
	//private void makeWithdrawal(int amount){
	
	//synchronized关键字表示线程需要一把钥匙来存取同步化过的线程
	private synchronized void makeWithdrawal(int amount){
		if(account.getBalance()>=amount){
			System.out.println(Thread.currentThread().getName() + " is about to withdraw");
			try{
				System.out.println(Thread.currentThread().getName() + " is going to sleep");
				Thread.sleep(500);
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
		}else{
			System.out.println("Sorry, not enougt for" + Thread.currentThread().getName());
		}
	}
}
