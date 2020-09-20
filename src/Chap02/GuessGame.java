package Chap02;

//2013.03.19
//Michel
public class GuessGame {
	Player p1;
	Player p2;
	Player p3;
	
	public void startGame(){
		//创建Player对象
		p1=new Player();
		p2=new Player();
		p3=new Player();
		
		//声明三个变量来保存猜测的数字
		int guessp1=0;
		int guessp2=0;
		int guessp3=0;
		  
		//声明三个变量来保存是否猜中
		boolean p1isRight =false;
		boolean p2isRight =false;
		boolean p3isRight =false;
		 
		//产生谜底数字
		int targetNumber=(int)(Math.random()*20);
		System.out.println("I'm thinking of a number between 0 and 19...");
		
		while(true){
			System.out.println("Number to guess is "+targetNumber);
			
			p1.guess();
			p2.guess();
			p3.guess();
			
			//取得并列出每个Player所猜测的数字
			guessp1=p1.number;
			System.out.println("Player one guessed "+guessp1);
			
			guessp2=p2.number;
			System.out.println("Player two guessed "+guessp2);
			
			guessp3=p3.number;
			System.out.println("Player three guessed "+guessp3);
			
			//检查是否猜中，并保存
			if(guessp1==targetNumber){
				p1isRight=true;
			}
			else {
				p1isRight=false;
			}
			if(guessp2==targetNumber){
				p2isRight=true;
			}
			else{
				p2isRight=false;
			}
			if(guessp3==targetNumber){
				p3isRight=true;
			}
			else{
				p3isRight=false;
			}
			
			//如果有一个或多个猜中
			if(p1isRight||p2isRight||p3isRight){
				System.out.println("We have a winner!");
				System.out.println("Player one got it right? "+p1isRight);
				System.out.println("Player two got it right? "+p2isRight);
				System.out.println("Player three got it right? "+p3isRight);
				System.out.println("Game is over.");
				break;   //游戏结束，终止循环
			}
			else{
				System.out.println("Players will have to try again.");
			}
		}
	}
}
