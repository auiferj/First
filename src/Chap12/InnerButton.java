package Chap12;

/**
 * 2013.04.07
 * Michel
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InnerButton {
	
	JFrame frame;
	JButton b;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InnerButton gui = new InnerButton();
		gui.go();
	}
	
	public void go(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		b = new JButton("A");
		//b.addActionListener();  //-->要传入参数
		b.addActionListener(new BListener());
		
		frame.getContentPane().add(BorderLayout.SOUTH,b);
		frame.setSize(200,100);
		frame.setVisible(true);
	}
	
	//class BListener extends ActionListener {  //-->error
	class BListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if(b.getText().equals("A")){
				b.setText("B");
			} else {
				b.setText("A");
			}
		}
	}
}
