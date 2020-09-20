package Chap12;

/**
 * 2013.03.29
 * Michel
 */

import javax.swing.*;

import java.awt.event.*;

public class SimpleGuilB implements ActionListener {
	JButton button;
	
	public static void main(String[] args) { 
		SimpleGuilB gui = new SimpleGuilB();
		gui.go();
	}
	
	public void go(){
		JFrame frame = new JFrame();          //创建Frame
		button = new JButton("click me");     //给button创建实例
		
		button.addActionListener(this);       //向按钮注册
		
		frame.getContentPane().add(button);    //button添加到frame的pane上
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);    //设定size
		frame.setVisible(true);    //显示frame
	}
	
	//实现接口的方法
	public void actionPerformed(ActionEvent event){
		button.setText("I've been clicked!");
	}

}
