package Chap09;

import java.awt.Color;

/**
 * 2013.03.27
 * Michel
 */
public class Mini extends Car {
	Color color;
	
	public Mini(){
		this(Color.RED);
	}
	
	public Mini(Color c){
		super("Mini");
		color = c;
	}
	
	public Mini(int size){
		this(Color.RED);
		//super(size);
	}
}
