package Chap16;

/**
 * 2012.04.17
 * Michel
 */
public class Book implements Comparable {
	String title;
	public Book(String t){
		title = t;
	}
	
	@Override
	public int compareTo(Object b) {
		// TODO Auto-generated method stub
		Book book = (Book) b;
		return (title.compareTo(book.title));
	}
	
	
}
