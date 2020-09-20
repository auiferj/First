package Chap09;

/**
 * 2013.03.27
 * Michel
 */
public class SimUnit {
	String botType;
	SimUnit(String type){
		botType = type;
		System.out.println("mark.");
	}
	
	int powerUse(){
		if("Retention".equals(botType)){
			return 2;
		} else {
			return 4;
		}
	}
}
