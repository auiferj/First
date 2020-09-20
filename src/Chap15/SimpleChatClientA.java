package Chap15;

/**
 * 2013.04.12
 * Michel
 * 聊天客户端程序
 * 第一版：只能发送的版本。(需要后面的服务器代码执行后再运行)
 */
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
public class SimpleChatClientA {
	JTextField outgoing;
	PrintWriter writer;
	Socket sock;
	
	public void go(){
		//注册按钮的监听者
		JFrame frame = new JFrame("Ludicrously Simple CHat Client");
		JPanel mainPanel = new JPanel();
		outgoing = new JTextField(20);
		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(new SendButtonListener());
		mainPanel.add(outgoing);
		mainPanel.add(sendButton);
		frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
		//调用setUpNetworking()
		setUpNetworking();
		frame.setSize(400,500);
		frame.setVisible(true); 
	}
	
	private void setUpNetworking(){
		//建立Socket,PrintWriter
		//赋值PrintWriter给实例变量
		try{
			sock = new Socket("127.0.0.1",5000);
			writer = new PrintWriter(sock.getOutputStream());
			System.out.println("networking established");
		} catch (IOException ex){
			ex.printStackTrace();
		}
	}
	
	public class SendButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			//取得文字字段内容
			try{
				writer.println(outgoing.getText());
				writer.flush();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			//传送到服务器上
			outgoing.setText("");
			outgoing.requestFocus();
		}
	}
	
	public static void main(String[] args){
		new SimpleChatClientA().go();
	}
}
