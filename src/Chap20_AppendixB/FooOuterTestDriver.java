package Chap20_AppendixB;

/**
 * 2013.04.22
 * Michel
 */
class FooOuterTestDriver {
	public static void main(String[] args){
		 FooOuter.BarInner foo = new FooOuter.BarInner();
		 foo.sayIt();
	}
}
