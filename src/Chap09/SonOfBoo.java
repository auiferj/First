package Chap09;

/**
 * 2013.03.27
 * Michel
 */
public class SonOfBoo extends Boo {
	public SonOfBoo(){
		super("boo");
	}
	
	public SonOfBoo(int i){
		super("Fred");
	}
	
	public SonOfBoo(String s){
		super(42);
	}
	
//	public SonOfBoo(int i,String s){
//		//无法通过编译
//	}
	
//	public SonOfBoo(String a,String b,String c){
//		super(a,b);  //参数不匹配，无法通过编译
//	}
	
	public SonOfBoo(int i, int j){
		super("man",j);
	}
	
//	public SonOfBoo(int i, int j, int y){
//		super(i,"star");  //参数不匹配，无法通过编译
//	}
}
