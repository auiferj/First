package Chap11;

/**
 * 2013.03.29
 * Michel
 */
public class ExTestDrive {
	
	public static void main(String[] args) {
		
		try{
			//String test = args[0];  //-->无法通过编译
			
			//yes和no换着用
			String test = "yes";   
			//String test = "no";
			
			System.out.print("t");
			System.out.print("h");

			doRisky(test);
			
			System.out.print("r");
			System.out.print("o");
			  
		} catch(MyEx e){
			System.out.print("a");
		} finally {
			System.out.print("w");
			System.out.print("s"); 
		}
	}

	static void doRisky(String t) throws MyEx{
		if("yes".equals(t)){
			throw new MyEx();
		}
	}
}

