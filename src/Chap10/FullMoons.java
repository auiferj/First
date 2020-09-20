package Chap10;

/**
 * 2013.03.28
 * Michel
 */
//import java.io.*;
import java.util.*;
import static java.lang.System.out;
//static import java.lang.System.out;  //-->error
public class FullMoons {
	static int DAY_IM = 60 * 60 * 24;
	
	public static void main(String[] args) { 
		//Calendar c = new Calendar();  //-->error
		Calendar c = Calendar.getInstance();
		c.set(2004,0,7,15,40);
		long day1 = c.getTimeInMillis();
		 
		for(int x=0;x<60;x++){
			day1 += (DAY_IM * 29.52);
			c.setTimeInMillis(day1);
			out.println(String.format("full moon on %tc", c));
		}
	}
 

}
