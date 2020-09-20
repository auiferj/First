package Chap05;

/**
 * 2013.03.22
 * Michel
 */
public class MultiFor {
	public static void main(String[] args){
		for(int x=0;x<4;x++){
			for(int y=4;y>2;y--){ 
				System.out.println(x + " " + y); 
			}	
			if(x==1){   
				x++;      //让x跳过2
			}
		} 
	}
}
