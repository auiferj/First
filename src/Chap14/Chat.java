package Chap14;

/**
 * 2013.04.08
 * Michel
 */
import java.io.*;
import java.net.*;
public class Chat implements Serializable {
	transient String currnrtID; //这个变量标记为不需要序列化
	String userName;
	//...
}
