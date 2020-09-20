package Chap15;

/**
 * 2013.04.12
 * Michel
 * 在cmd里输入 "netstat -nao" 看下你serverSocket所监听的端口有没有存在
 */
import java.io.*;
import java.net.*;
public class DailyAdviceClient {
	public void go(){
		
		try {
			Socket s = new Socket("127.0.0.1",4242);
				
			InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
			BufferedReader reader = new BufferedReader(streamReader);
			
			String advice = reader.readLine();
			System.out.println("Today you should: " + advice);
			
			reader.close();
		} catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] arg){
		DailyAdviceClient client = new DailyAdviceClient();
		client.go();
	}
}
