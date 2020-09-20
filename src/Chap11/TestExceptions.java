package Chap11;

/**
 * 2013.03.28
 * Michel
 * 
 */

public class TestExceptions {
	
	public static void main(String[] args) {
		//String test = "no";
		String test = "yes";
		try{
			System.out.println("start try");
			doRisky(test);
			System.out.println("end try");
		} catch (ScaryException se) {
			System.out.println("scary exception");
		} finally {
			System.out.println("finally");
		}
		System.out.println("end of main");
	}
	 
	//书中假设ScaryException继承自Exception，
	//(API中没有此类)因此要自己写ScaryException类
	static void doRisky(String test) throws ScaryException {
		System.out.println("start risky");
		if("yes".equals(test)){
			throw new ScaryException();
		}
		System.out.println("end risky");
		return;
	}
}
