package Chap20_AppendixB;

/**
 * 2013.04.22
 * Michel
 */
import java.awt.event.*;

import javax.swing.*;
public class TestAnon {
	public static void main(String[] args){
		JFrame frame = new JFrame();
		JButton button = new JButton("click");
		frame.getContentPane().add(button);
		//button.addActionListener(quitListener)
		
		button.addActionListener(
			new ActionListener() { 
				@Override
				public void actionPerformed(ActionEvent ev) {
					// TODO Auto-generated method stub
					System.exit(0);
				}
			}
		);
	}
}
