package Chap10;

/**
 * 2013.03.27
 * Michel
 */
public class Song {
	String title;   //实例变量的值会影响到play()方法的行为
	public Song(String t){
		title = t;
	}
	
	public void play(){
		SoundPlayer player = new SoundPlayer();
		player.playSound(title);  //title 的值会决定play（）方法所播放的内容
	}
	
	//静态方法,关键字：static
	public static int min(int a, int b){
		return Math.min(a,b);
	}
}
