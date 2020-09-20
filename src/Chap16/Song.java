package Chap16;

/**
 * 2013.04.16
 * Michel
 * 有覆盖过的hashCode()与equals()的  2013.04.17
 */
public class Song implements Comparable<Song>{
	//对应四种属性的四个实例变量
	String title; 
	String artist;
	String rating;
	String bpm;
	
	@Override
	public boolean equals(Object aSong){
		Song s = (Song) aSong;
		return getTitle().equals(s.getTitle());
	}
	
	@Override
	public int hashCode(){
		return title.hashCode();
	}
	
	public int compareTo(Song s){
		return title.compareTo(s.getTitle()); //返回String比较的结果
	}
	
	//变量都会在创建时从构造函数中设定
	Song(String t,String a,String r,String b){
		title = t;
		artist = a;
		rating = r;
		bpm = b;
	}

	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}

	public String getRating() {
		return rating;
	}

	public String getBpm() {
		return bpm;
	}
	
	//将toString方法覆盖，让它返回歌名
	public String toString(){
		return title;
	}
}