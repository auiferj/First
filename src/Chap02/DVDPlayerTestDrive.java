package Chap02;

//2013.03.19
//Michel
public class DVDPlayerTestDrive {
	public static void main(String [] args) {
		DVDPlayer d = new DVDPlayer();
		d.canRecord = true;
		//d.playDVD();  //del
		if (d.canRecord == true) {
			d.recordDVD();
		}
	}
}
