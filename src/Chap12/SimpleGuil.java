package Chap12;

/**
 * 2013.03.29
 * Michel
 */
import javax.swing.*;
public class SimpleGuil {
	public static void main(String[] args){
		
		JFrame frame = new JFrame();                 //创建Frame
		JButton button = new JButton("click me");    //创建 button
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(button);    //button添加到frame的pane上
		
		frame.setSize(300,300);    //设定size
		
		frame.setVisible(true);    //显示frame
	
	}
}
