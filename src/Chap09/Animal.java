package Chap09;

/**
 * 2013.03.27
 * Michel
 */
public class Animal {
	private String name;
	
	public String getName(){
		return name;
	}
	
	public Animal(String theName){
		System.out.println("Making an Animal");
		name = theName;
	}
}