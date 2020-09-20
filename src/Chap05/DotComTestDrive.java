package Chap05;
 
/**
 * @author user06
 *
 */
import java.util.ArrayList;

public class DotComTestDrive {
	public static void main(String[] args){
		/*
		 * 最初版 注释掉
		SimpleDotCom dot = new SimpleDotCom();
		
		int[] locations = {2,3,4};
		dot.setLocationCells(locations);
		
		String userGuess = "2";
		String result = dot.checkYourself(userGuess);
		String testResult = "failed";
		if(result.equals("hit")){
			testResult = "passed";
		}
		
		System.out.println(testResult);
		*/
		
		int numOfGuesses = 0;   //记录玩家猜测次数
		GameHelper helper = new GameHelper();
		
		DotCom theDotCom = new DotCom();
		int randomNum =(int)(Math.random() * 5);  //随机生成第一格位置
		
		ArrayList<String> locations = new ArrayList<String>();
		locations.add(String.valueOf(randomNum));
		locations.add(String.valueOf(randomNum+1));
		locations.add(String.valueOf(randomNum+2)); 
		theDotCom.setLocationCells(locations);
		boolean isAlive = true;
		
		while(isAlive == true){
			String guess = helper.getUserInput("enter a number:");
			String result = theDotCom.checkYourself(guess);
			numOfGuesses++;
			if(result.equals("kill")){
				isAlive = false;
				System.out.println("You took " + numOfGuesses + " guessed");
			} 
		}
	}
}
