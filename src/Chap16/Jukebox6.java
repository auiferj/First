package Chap16;

/**
 * 2013.04.17
 * Michel
 * 把点歌系统改成使用HashSet
 */
import java.util.*;
import java.io.*;
public class Jukebox6 {
	ArrayList<Song> songList = new ArrayList<Song>();
	public static void main(String[] args){
		new Jukebox6().go();
	}
	
	class ArtistCompare implements Comparator<Song>{ 
		@Override
		public int compare(Song one, Song two) {
			// TODO Auto-generated method stub
			return one.getArtist().compareTo(two.getArtist());
		}
	}
	
	public void go(){
		getSongs();
		System.out.println(songList);
		Collections.sort(songList);
		System.out.println(songList);
		
		//ArrayList
		ArtistCompare artistCompare = new ArtistCompare(); //创建Comparator的实例
		Collections.sort(songList,artistCompare); 
		System.out.println(songList);
		
		//HashSet
		HashSet<Song> songSet = new HashSet<Song>();  //创建参数化的HashSet来保存Song
		songSet.addAll(songList);  //addAll可以复制其他集合的元素，效果跟一个一个加进去一样
		System.out.println(songSet);
	}
	 
	void getSongs(){
		try{
			File file = new File("SongListMore.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while((line=reader.readLine())!=null){
				addSong(line);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	void addSong(String lineToParse){
		String[] tokens = lineToParse.split("/");
		
		Song nextSong = new Song(tokens[0],tokens[1],tokens[2],tokens[3]);
		songList.add(nextSong);
	}
}
