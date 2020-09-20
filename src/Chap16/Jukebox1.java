package Chap16;

/**
 * 2013.04.16
 * Michel
 * ArrayList没有sort方法。。
 */
import java.util.*;
import java.io.*;
public class Jukebox1 {
	
	ArrayList<String> songList = new ArrayList<String>();
	
	public static void main(String[] args){
		new Jukebox1().go();
	}
	
	public void go(){
		getSongs();
		System.out.println(songList);
		
		//调用Collection静态的sort()然后再列出清单。
		//第二次的输出会依照字母排序
		Collections.sort(songList);
		System.out.println(songList);
	}
	
	void getSongs(){
		try{
			File file = new File("SongList.txt");
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
		songList.add(tokens[0]); 
	}
}