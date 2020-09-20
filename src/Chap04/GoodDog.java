package Chap04;

/**
 * 2013.03.21
 * Michel
 * 封装GoodDog
 */
public class GoodDog {
	private int size;
	
	public int getSize(){
		return size;
	}
	
	public void setSize(int s){
		size = s;
	}
	
	void bark(){
		if(size>60){
			System.out.print("Woof! Woof!");
		} else if(size>14){
			System.out.print("Ruff! Ruff!");
		} else {
			System.out.print("Yip! Tip!");
		}
	}
}
