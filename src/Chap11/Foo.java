package Chap11;

/**
 * 2013.03.29
 * Michel
 */
public class Foo {
	public void go(){
		Laundry laundry = new Laundry();
		try{
			laundry.doLaundry();
		} catch(PantsException pex){
			//
		} catch(LingerieException lex){
			//
		}
	}
}
