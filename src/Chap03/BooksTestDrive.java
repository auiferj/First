package Chap03;
 
/**
 * 2013.03.20
 * Michel
 */
public class BooksTestDrive {
	public static void main(String [] args) {
		Books[] myBooks = new Books[3];
		int x = 0;
		
		myBooks[0] = new Books();    //add  new对象赋给引用
		myBooks[1] = new Books();    //add
		myBooks[2] = new Books();    //add
		
		myBooks[0].title = "The Grapes of Java";
		myBooks[1].title = "The Java Gatsby";
		myBooks[2].title = "The Java Cookbook";
		myBooks[0].author = "bob";
		myBooks[1].author = "sue";
		myBooks[2].author = "ian";
		while (x < 3) {
			System.out.print(myBooks[x].title);
			System.out.print(" by ");
			System.out.println(myBooks[x].author);
			x = x + 1;
		}
		 
	}
}
