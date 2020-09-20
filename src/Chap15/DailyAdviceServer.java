package Chap15;

/**
 * 2013.04.12
 * Michel
 */
import java.io.*;
import java.net.*;
public class DailyAdviceServer {
	String[] adviceList = {
			"Take smaller bites",
			"Go for the tight jeans,No they do NOT make you look fat.",
			"One word: inappropriate",
			"Just for today, be honest. Tell your boss what you *really* think",
			"YOu might want to rethink that haircut"
			};
	
	public void go(){
		try{
			//ServerSocket会监听客户端对这台机器在4242端口上的要求
			ServerSocket serverSock = new ServerSocket(4242);
			
			//服务器进入无限循环等待服务端的请求
			while(true){
				Socket sock = serverSock.accept();  //这个方法会停下来等待要求达到之后才会继续
				
				PrintWriter writer = new PrintWriter(sock.getOutputStream());
				String advice = getAdvice();
				writer.println(advice);
				writer.close();
				System.out.println(advice);
			}
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	private String getAdvice(){
		int random = (int) (Math.random() * adviceList.length);
		return adviceList[random];
	}
	
	public static void main(String[] args){
		DailyAdviceServer server = new DailyAdviceServer();
		server.go();
	}
	
	
}
