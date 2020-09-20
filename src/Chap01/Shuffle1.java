package Chap01;

//2013.03.18
//Michel
public class Shuffle1 {
	public static void main(String[] args){
		int x=3;
		 
		while(x>0){ 
			if(x>2){
				System.out.print("a");
			}
			
			System.out.print("-");
			x--;
			
			if(x==2){
				System.out.print("b c");
			}
			if(x==1){
				System.out.print("d");
				x--;
			} 
		}
	}
}
