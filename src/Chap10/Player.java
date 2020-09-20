package Chap10;

/**
 * 2013.03.27
 * Michel
 */
public class Player {
	public static int playerCount = 0;
	private String name;
	public Player(String n){
		name = n;
		playerCount++;
	}
}
