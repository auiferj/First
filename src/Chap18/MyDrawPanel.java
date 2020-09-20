package Chap18;

/**
 * 2013.04.19
 * Michel
 * MiniMusicService中用
 * 内容与Chap12中的MiniMusicServiceC相同
 */

import java.awt.*;

import javax.swing.*;
public class MyDrawPanel extends JPanel {
	//填入彩色(见书本367页)
	public void paintComponent(Graphics g){  
		//由参数g所引用的对象实际上是个Grahpics2D的实例
		Graphics2D g2d = (Graphics2D) g;
		
		int red = (int) (Math.random() * 255);
		int green = (int) (Math.random() * 255);
		int blue = (int) (Math.random() * 255);
		Color startColor = new Color(red,green,blue);
		
		red = (int) (Math.random() * 255);
		green = (int) (Math.random() * 255);
		blue = (int) (Math.random() * 255);
		Color endColor = new Color(red,green,blue);
		
		GradientPaint gradient = new GradientPaint(70, 70, startColor, 150, 150, endColor);
		g2d.setPaint(gradient);
		g2d.fillOval(70, 70, 100, 100);
	}
	 
}
