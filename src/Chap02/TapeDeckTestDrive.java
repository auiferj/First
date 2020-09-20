package Chap02;

//2013.03.19
//Michel
public class TapeDeckTestDrive {
	public static void main(String [] args) {
		TapeDeck t=new TapeDeck();  //add
		t.canRecord = true;
		t.playTape();
		if (t.canRecord == true) {
			t.recordTape();
		}
	}
}
