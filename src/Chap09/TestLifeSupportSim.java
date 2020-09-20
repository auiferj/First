package Chap09;

/**
 * 2013.03.27
 * Michel
 */
import java.util.*;
public class TestLifeSupportSim {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList aList = new ArrayList();
		V2Radiator v2 = new V2Radiator(aList);
		V3Radiator V3 = new V3Radiator(aList);
		for(int z=0;z<20;z++){
			RetentionBot ret = new RetentionBot(aList);
		}
	}
}
