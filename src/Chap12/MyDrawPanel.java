package Chap12;
 
/**
 * 2013.03.29
 * Michel
 */

import java.awt.*;
import javax.swing.*;
public class MyDrawPanel extends JPanel {
	  
	public void paintComponent(Graphics g){
		g.setColor(Color.ORANGE);
		g.fillRect(20,50,100,100);
		
		//显示JPEG
		Image image = new ImageIcon("catzilla.jpg").getImage();
		g.drawImage(image,3,4,this);
		
		//在黑色背景画上随机彩色的圆圈
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		int red = (int) (Math.random()*255);
		int green = (int) (Math.random()*255);
		int blue = (int) (Math.random()*255);
		Color randomColor = new Color(red,green,blue);
		g.setColor(randomColor);
		g.fillOval(70, 70, 100, 100);  //填充椭圆形
		
		//
		
	}

}
