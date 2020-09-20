package Chap12;

/**
 * 2013.04.01
 * Michel
 */
import javax.swing.*;
import java.awt.*;
public class SimpleAnimation {
	int x = 70;
	int y = 70;
	
	public static void main(String[] args) { 
		 SimpleAnimation gui = new SimpleAnimation();
		 gui.go();
	}
	
	public void go(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyDrawPanel drawPanel = new MyDrawPanel();
		
		frame.getContentPane().add(drawPanel);
		frame.setSize(300,300);
		frame.setVisible(true);
		
		//for(int i=0;i< frame.getHeight();i++){ 
		for(int i=0;i<130;i++){ 
			x++;
			y++;
			
			drawPanel.repaint(); 
			//frame.repaint();   //用于刷新frame
			
			try{
				Thread.sleep(50);      //sleep,便于看清移动轨迹。
			} catch(Exception ex) {
				
			}
		}
	}
	
	class MyDrawPanel extends JPanel {
		public void paintComponent(Graphics g){
			//重绘前先用默认背景色清除原来的轨迹
			//（其实也可以不写下面2句，用上面的frame.repaint()）
			g.setColor(Color.white);
			g.fillOval(x, y, this.getWidth(), this.getHeight());
			
			g.setColor(Color.green);
			g.fillOval(x, y, 40, 40);
		}
	}
}
