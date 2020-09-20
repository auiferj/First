package Chap04;

/**
 * 2013.03.20
 * Michel
 */
public class ElectricGuitar {
	String brand;
	int numOfPickups;
	boolean rockStarUsesIt;
	
	String getBrand(){
		return brand;
	}
	
	void setBrand(String aBrand){
		brand = aBrand;
	}
	
	int getNumOfPickups(){
		return numOfPickups;
	}
	
	void setNumOfPickups(int num){
		numOfPickups = num;
	}
	
	boolean getRockStarUseIt(){
		return rockStarUsesIt;
	}
	
	void setRockStarUsesit(boolean yesOrNo){
		rockStarUsesIt = yesOrNo;
	}
}
