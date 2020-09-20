package Chap12;

/**
 * 2013.04.01
 * Michel
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TwoButtons {
	JFrame frame;
	JLabel label;
	
	public static void main(String[] args){
		TwoButtons gui = new TwoButtons();
		gui.go();
	}
	
	private void go(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton labelButton = new JButton("Change Label");
		labelButton.addActionListener(new LabelListener());
		
		JButton colorButton = new JButton("Change Circle");
		colorButton.addActionListener(new ColorListener());
		
		label = new JLabel("I'm a label");
		MyDrawPanel drawPanel = new MyDrawPanel();
		
		frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
		frame.getContentPane().add(BorderLayout.CENTER,drawPanel);
		frame.getContentPane().add(BorderLayout.EAST,labelButton);
		frame.getContentPane().add(BorderLayout.WEST,label);
		
		frame.setSize(300,300);
		frame.setVisible(true);
	}
	
	//内部类
	class LabelListener implements ActionListener {
		public void actionPerformed(ActionEvent event){
			label.setText("Ouch!");
		}
	}
	
	//内部类	
	class ColorListener implements ActionListener {
		public void actionPerformed(ActionEvent event){
			frame.repaint();
		}
	}
}
