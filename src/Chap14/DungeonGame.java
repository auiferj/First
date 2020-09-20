package Chap14;

/**
 * 2013.04.10
 * Michel
 */
import java.io.*;
public class DungeonGame implements Serializable {
	public int x = 3;
	transient long y = 4;
	private short z = 5;
	int getX(){
		return x;
	}
	long getY(){
		return y;
	}
	short getZ(){
		return z;
	}
}
