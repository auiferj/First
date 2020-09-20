package Chap12;

/**
 * 2013.04.07
 * Michel
 * 第三版:与音乐同步输出图形 （图形界面）
 *  MyDrawPanel名字与之前示例有冲突，此处我改成了MyDrawPanelMyDrawPanelForPlayer3
 */
 
import java.awt.*;
import javax.sound.midi.*;
import javax.swing.*;
 
public class MyDrawPanelForPlayer3 extends JPanel implements ControllerEventListener {
	boolean msg = false;
	
	public void controlChange(ShortMessage event){
		msg = true;
		repaint();
	}
	
	public void paintComponent(Graphics g){
		if(msg){  //判断是否是ControllerEvent所引发的重绘
			Graphics2D g2 = (Graphics2D) g;
			
			int r = (int) (Math.random() * 250);
			int gr = (int) (Math.random() * 250);
			int b = (int) (Math.random() * 250);
			
			g2.setColor(new Color(r,gr,b));
			
			int ht = (int) ((Math.random() * 120)+10);
			int width = (int) ((Math.random()* 120) + 10);
			
			int x = (int) ((Math.random() * 40) + 10);
			int y = (int) ((Math.random() * 40) + 40);
			
			g2.fillRect(x,y,ht,width);
			msg = false;
		}
	}
}
