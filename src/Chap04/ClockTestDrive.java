package Chap04;

/**
 * 2013.03.21
 * Michel
 */
public class ClockTestDrive {
	public static void main(String[] args){
		Clock c = new Clock();
		c.setTime("1245");
		String tod = c.getTime();
		System.out.println("time: " + tod);
	}
}