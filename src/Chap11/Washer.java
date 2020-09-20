package Chap11;

/**
 * 2013.03.29
 * Michel
 */
public class Washer {
	Laundry laundry = new Laundry();
	
	//下面foo和main方法都躲避了异常，因此没人处理，但有duck掉，所以可以通过编译
	public void foo() throws ClothingException, PantsException, LingerieException{
		laundry.doLaundry();
	}
	
	public static void main(String[] args) throws ClothingException, PantsException, LingerieException {
		Washer a = new Washer();
		a.foo();
	}
}
