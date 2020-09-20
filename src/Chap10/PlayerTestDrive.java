package Chap10;

/**
 * 2013.03.27
 * Michel
 */
public class PlayerTestDrive {
	public static void main(String[] args){
		System.out.println(Player.playerCount);
		Player one = new Player("Tiger Woods");
		System.out.println(Player.playerCount);  //静态变量通过类名称存取
	}
}