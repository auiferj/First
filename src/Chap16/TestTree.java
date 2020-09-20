package Chap16;

/**
 * 2013.04.17
 * Michel
 */
import java.util.*;
public class TestTree {
	public void go(){
		Book b1 = new Book("How Cats Works");
		Book b2 = new Book("Remix your Body");
		Book b3 = new Book("Finding Emo");
		
		TreeSet<Book> tree = new TreeSet<Book>(); 
		tree.add(b1);
		tree.add(b2);
		tree.add(b3);
		System.out.println(tree);
	}
	
	public static void main(String[] args){
		new TestTree().go();
	}
}
