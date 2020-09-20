package Chap09;

/**
 * 2013.03.27
 * Michel
 */
public class Hippo extends Animal {
	public Hippo (String name){
		
		super(name);
		//super();
		System.out.println("Making a Hippo");
		//super();    // -->error 父类构造器必须立刻调用，而不是子类构造器已经执行后再调用
	}
}
