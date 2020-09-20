package Chap01;

//2013.03.18
//Michel
public class BeerSong {
	public static void main(String[] args){
		int beerNum=99;
		String word="bottles";
		while(beerNum>0){
			
			if(beerNum==1){
				word="bottle";
			}
			System.out.println(beerNum+ " " + word + " of the beer on the wall");
			beerNum--;
		}
		System.out.println("No more bottles of bear on the wall");
	}
}
