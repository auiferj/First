package Chap20_AppendixB;

/**
 * 2013.04.22
 * Michel
 */
class FooOuter {
	static class BarInner{
		void sayIt(){
			System.out.println("method of a static inner class");
		}
	}
}
