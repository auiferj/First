package Chap12;

/**
 * 2013.03.29
 * Michel
 * 按下按钮圆圈就会改变颜色
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
 
public class SimpleGui3C implements ActionListener {
	JFrame frame;
	public static void main(String[] args) { 
		SimpleGui3C gui = new SimpleGui3C();
		gui.go();
	}
	
	public void go(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button = new JButton("Change colors"); 
		button.addActionListener(this);
		
		//书上用的MyDrawPanel，我这里为了方便重新写了个MyDrawPanelC，内容没变
		MyDrawPanelC drawPanel = new MyDrawPanelC();
		
		frame.getContentPane().add(BorderLayout.SOUTH,button);
		frame.getContentPane().add(BorderLayout.CENTER,drawPanel);
		frame.setSize(300,300);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent event){
		frame.repaint();  //frame重绘
	}
 
}
