package Chap19_AppendixA;

/**
 * 2013.04.22
 * BeatBox最终版（服务器端） 
 * 服务器端接收并传送两个对象
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
 * 先运行服务器端：MusicServer.java， 再运行BeatBoxFinal.java
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
 * 如果4242端口被占用，使用如下方法关闭：
 * cmd里输入命令  netstat -a -n -o
 * 最后一个选项表示连接所在进程id. 找到要找端口的PID
 * 然后打开任务管理器, 切换到进程选项卡, 在菜单栏选择查看->选择列, 选择PID
 * 在列表中找到PID对应的进程关闭就可以了
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
 */

import java.io.*;
import java.net.*;
import java.util.*;

public class MusicServer {
	ArrayList<ObjectOutputStream> clientOutputStreams;
	
	public static void main(String[] args){
		new MusicServer().go();
	}
	
	public class ClientHandler implements Runnable {
		
		ObjectInputStream in;
		Socket clientSocket;
		
		public ClientHandler(Socket socket){
			try{
				clientSocket = socket;
				in = new ObjectInputStream(clientSocket.getInputStream());
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		
		public void run(){
			Object o2 = null;
			Object o1 = null;
			
			try{
				while((o1 = in.readObject()) != null){
					o2 = in.readObject();
					
					System.out.println("read two objects");
					tellEveryOne(o1,o2);
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
	
	public void go() {
		clientOutputStreams = new ArrayList<ObjectOutputStream>();
		 
		try{
			ServerSocket serverSock = new ServerSocket(4242);
			
			while(true){
				Socket clientSocket = serverSock.accept();
				ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
				clientOutputStreams.add(out);
				
				Thread t = new Thread(new ClientHandler(clientSocket));
				t.start();
				
				System.out.println("got a connection");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void tellEveryOne(Object one, Object two){
		Iterator it = clientOutputStreams.iterator();
		while(it.hasNext()){
			try{
				ObjectOutputStream out = (ObjectOutputStream) it.next();
				out.writeObject(one);
				out.writeObject(two);
			}catch(Exception ex){
				ex.printStackTrace();
			} 
		}
	}
}
