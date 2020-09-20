package Chap18;

/**
 * 2013.04.19
 * Michel
 * 实现Service的通用服务
 */
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class DiceService implements Service {
	
	JLabel label;
	JComboBox numOfDice;
	
	/*
	 * (non-Javadoc)
	 * @see Chap18.Service#getGuiPanel()
	 * 这是很重要的方法！
	 * 客户端会调用这个定义在Service中的方法来创建实际的骰子
	 */
	public JPanel getGuiPanel(){
		JPanel panel = new JPanel();
		JButton button = new JButton("Roll 'em!'");
		String[] choices = {"1","2","3","4","5"};
		numOfDice = new JComboBox(choices);
		label = new JLabel("dice values here");
		button.addActionListener(new RollEmListener());
		panel.add(numOfDice);
		panel.add(button);
		panel.add(label);
		
		return panel;
	}
	
	public class RollEmListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ev) {
			// TODO Auto-generated method stub
			//roll the dice
			String diceOutput = "";
			String selection = (String) numOfDice.getSelectedItem();
			int numOfDiceToRoll = Integer.parseInt(selection);
			for(int i=0;i<numOfDiceToRoll;i++){
				int r = (int) ((Math.random()*6)+1);
				diceOutput += (" " + r);
			}
			label.setText(diceOutput);
		}
		
	}
}
