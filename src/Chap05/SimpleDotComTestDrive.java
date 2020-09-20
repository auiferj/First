package Chap05;

/**
 * 2013.03.21
 * Michel
 */
public class SimpleDotComTestDrive {
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
		
		SimpleDotCom theDotCom = new SimpleDotCom();
		int randomNum =(int)(Math.random() * 5);  //随机生成第一格位置
		
		int[] locations = {randomNum, randomNum+1, randomNum+2}; 
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