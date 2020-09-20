package Chap05;

/**
 * 2013.03.21
 * Michel
 */
public class SimpleDotCom {
	
	int[] locationCells;  //
	int numOfHits = 0;    //累计击中次数
	
	public void setLocationCells(int[] locs){
		locationCells = locs;
	}
	
	public String checkYourself(String stringGuess){
		int guess = Integer.parseInt(stringGuess);  //将String转换为Int
		String result = "miss";
		
		for(int cell : locationCells){   //对locations中的每个元素执行一次
			if(guess == cell){
				result = "hit";          //击中
				numOfHits++;
				break;
			}
		}
		
		if(numOfHits == locationCells.length){
			result = "kill";
		}
		
		System.out.println(result);
		return result;
	}
}
