package Chap05;

/**
 * 2013.03.22
 * Michel
 */
import java.util.ArrayList;
public class DotCom {
	
	private ArrayList<String> locationCells; 
	 
	public void setLocationCells(ArrayList<String> locs){
		locationCells = locs;
	}
	
	public String checkYourself(String userInput){

		String result = "miss";
		
		int index = locationCells.indexOf(userInput); 
		
		if(index>=0){    //如果索引值大于0，命中！
			locationCells.remove(index); //防止之前命中同一点三次也能击沉的bug
			if(locationCells.isEmpty()){
				result = "kill";
			} else {
				result = "hit";
			}
		}
		System.out.println(result);
		return result;
	}
}
