package Chap13;

/**
 * 2013.04.08
 * Michel
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TextAreal implements ActionListener {
	
	JTextArea text;
	 
	public static void main(String[] args) {
		TextAreal gui = new TextAreal();
		gui.go();
	}
	
	public void go(){
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton button = new JButton("Just Click It");
		button.addActionListener(this);
		text = new JTextArea(10,20);
		text.setLineWrap(true);
		
		JScrollPane scroller = new JScrollPane(text);
		
		//指定只用垂直滚动条
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		panel.add(scroller);
		
		frame.getContentPane().add(BorderLayout.CENTER,panel);
		frame.getContentPane().add(BorderLayout.SOUTH,button);
		
		frame.setSize(350,300);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		// TODO Auto-generated method stub
		text.append("button click \n ");
	}
}
