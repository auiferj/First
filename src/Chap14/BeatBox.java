package Chap14;

/**
 * 2013.04.12
 * Michel
 * 增加了checkbox状态保存功能
 */
import java.awt.*; 
import javax.swing.*;
import javax.swing.Box;
import javax.sound.midi.*; 
import java.util.*;
import java.awt.event.*;
import java.io.*;
public class BeatBox {

	JPanel mainPanel;
	ArrayList<JCheckBox> checkboxList;   //把checkbox储存在ArrayList中
	Sequencer sequencer;
	Sequence sequence;
	Track track;
	JFrame theFrame;
	
	 
	//乐器的名称，以String的array维护
	String[] instrumentNames = {"Bass Drum","Closed Hi-Hat",
		"Open Hi-Hat","Acoustic Snare","Crash Cymbal","Hand Clap",
		"High Tom","Hi Bongo","Maracas","Whistle","Low Conga",
		"Cowbell","Vibraslap","Low-mid Tom","High Agogo",
		"Open Hi Conga"};
	
	//实际的乐器关键字，例如35是bass，42是Closed Hi-Hat
	int[] instruments = {35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};
	
 	public static void main(String[] args) {  
 		BeatBox gui = new BeatBox();
 		gui.buildGUI();  
	}
 	
 	public void buildGUI(){
 		  
 		JFrame theFrame = new JFrame("Cyber BeatBox");
 		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		BorderLayout layout = new BorderLayout();
 		JPanel background = new JPanel(layout);
 		//设定面板上摆设组件时的空白边缘
 		background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
 		
 		//ArrayList<JCheckBox> checkboxList = new ArrayList<JCheckBox>();  //这种写法会报空指针错误。
 		checkboxList = new ArrayList<JCheckBox>();  
 		Box buttonBox = new Box(BoxLayout.Y_AXIS);
 		
 		JButton start = new JButton("Start");
 		start.addActionListener(new MyStartListener());
 		buttonBox.add(start);
 		
 		JButton stop = new JButton("stop");
 		stop.addActionListener(new MyStopListener());
 		buttonBox.add(stop);
 		
 		JButton upTempo = new JButton("Tempo Up");
 		upTempo.addActionListener(new MyUpTempoListener());
 		buttonBox.add(upTempo);
 		
 		JButton downTempo = new JButton("Tempo Down");
 		downTempo.addActionListener(new MyDownTempoListener());
 		buttonBox.add(downTempo);
 		
 		JButton sendTempo = new JButton("Save List");
 		sendTempo.addActionListener(new MySendListener());
 		buttonBox.add(sendTempo);
 		
 		JButton readTempo = new JButton("Read List");
 		readTempo.addActionListener(new MyReadInListener());
 		buttonBox.add(readTempo);
 		
 		Box nameBox = new Box(BoxLayout.Y_AXIS);
 		for(int i = 0;i<16; i++){
 			nameBox.add(new Label(instrumentNames[i]));
 		}
 		
 		background.add(BorderLayout.EAST,buttonBox);
 		background.add(BorderLayout.WEST,nameBox);
 		
 		theFrame.getContentPane().add(background);
 		
 		GridLayout grid = new GridLayout(16,16);
 		grid.setVgap(1);
 		grid.setHgap(2);
 		mainPanel = new JPanel(grid);
 		background.add(BorderLayout.CENTER,mainPanel);
 		
 		//创建checkbox组，设定成未勾选。并加入到ArrayList和面板上
 		for(int i = 0;i < 256; i++){
 			JCheckBox c = new JCheckBox();
 			c.setSelected(false);
 			checkboxList.add(c);
 			mainPanel.add(c);
 		}
 		
 		setUpMidi();
 		
 		theFrame.setBounds(50,50,300,300);
 		theFrame.pack();
 		theFrame.setVisible(true);
 	}
 	
 	//一般的MIDI设置程序代码
 	public void setUpMidi(){
 		try{
 			sequencer = MidiSystem.getSequencer();
 			sequencer.open();
 			sequence = new Sequence(Sequence.PPQ,4);
 			track = sequence.createTrack();
 			sequencer.setTempoInBPM(120);
 		} catch(Exception e) {
 			e.printStackTrace();
 		}
 	}
 	
 	//创建出16个元素的数组来存储一项乐器的值。
 	//如果该节应该要演奏，其值会是关键值，否则值为0
 	public void buildTrackAndStart(){
 		int[] trackList = null;
 		
 		//清除掉旧的track做一个新的
 		sequence.deleteTrack(track);
 		track = sequence.createTrack();
 		
 		//对每个乐器都执行一次
 		for(int i = 0; i<16; i++){
 			trackList = new int[16];
 			
 			//设定代表乐器的关键字
 	 		int key = instruments[i];
 			
 	 		//对每一拍执行一次
 	 		for(int j=0; j<16; j++){
 	 			JCheckBox jc = (JCheckBox) checkboxList.get(j+(16*i));
 	 			if(jc.isSelected()){
 	 				trackList[j] = key;
 	 			} else {
 	 				trackList[j] = 0;
 	 			}
 	 		}
 	 		
 	 		//创建此乐器的事件并加到track上
 	 		makeTracks(trackList);
 	 		track.add(makeEvent(176,1,127,0,16));
 		}
 		 
 		//确保第16拍有时间，否则beatbox不会重复播放
 		track.add(makeEvent(192,9,1,0,15));
 		try{
 			sequencer.setSequence(sequence);
 			sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY); //指定无穷的重复次数
 			//开始播放
 			sequencer.start();
 			sequencer.setTempoInBPM(120);
 		}catch(Exception e){
 			e.printStackTrace();
 		} 
 	}
 	
 	//内部类 监听按钮
 	public class MyStartListener implements ActionListener{ 
		@Override
		public void actionPerformed(ActionEvent a) {
			// TODO Auto-generated method stub
			buildTrackAndStart();
		} 
 	}
 	
 	//内部类 监听按钮
 	public class MyStopListener implements ActionListener{ 
		@Override
		public void actionPerformed(ActionEvent a) {
			// TODO Auto-generated method stub
			sequencer.stop();
		} 
 	}
 	
 	//内部类 监听按钮
 	//节奏因子，预设为1.0，每次调整0.03
 	public class MyUpTempoListener implements ActionListener{ 
		@Override
		public void actionPerformed(ActionEvent a) {
			// TODO Auto-generated method stub
			float tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float) (tempoFactor * 1.03));
		} 
 	}
 	
 	//内部类 监听按钮
 	public class MyDownTempoListener implements ActionListener{ 
		@Override
		public void actionPerformed(ActionEvent a) {
			// TODO Auto-generated method stub
			float tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float) (tempoFactor * 0.97));
		} 
 	}
 	
 	public void makeTracks(int[] list){
 		for(int i = 0; i <16;i++){
 			int key = list[i];
 			if(key!=0){
 				track.add(makeEvent(144,9,key,100,i));
 				track.add(makeEvent(128,9,key,100,i+1));
 			}
 		}
 	}
 	
 	public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick){
 		MidiEvent event = null;
 		try {
 			ShortMessage a = new ShortMessage();
 			a.setMessage(comd,chan,one,two);
 			event = new MidiEvent(a,tick);
 		} catch(Exception e) {
 			e.printStackTrace();
 		}
 		return event;
 	}
 	
 	public class MySendListener implements ActionListener {
 		public void actionPerformed(ActionEvent a){
 			boolean[] checkboxState = new boolean[256];
 			for(int i = 0; i<256; i++){
 				JCheckBox check = (JCheckBox) checkboxList.get(i);
 				if(check.isSelected()){
 					checkboxState[i] = true;
 				}
 			}
 			 
 	 		try {
 	 			FileOutputStream fileStream = new FileOutputStream(new File("Checkbox.ser"));
 	 			ObjectOutputStream os = new ObjectOutputStream(fileStream);
 	 			os.writeObject(checkboxState);
 	 		} catch(Exception ex){
 	 			ex.printStackTrace();
 	 		}
 		} 
 	}
 	
 	public class MyReadInListener implements ActionListener {
 		public void actionPerformed(ActionEvent a){
 			boolean[] checkboxState = null;
 			try {
 				FileInputStream fileIn = new FileInputStream(new File("checkbox.ser"));
 				ObjectInputStream is = new ObjectInputStream(fileIn);
 				checkboxState = (boolean[]) is.readObject();
 			} catch(Exception ex){
 				ex.printStackTrace();
 			}
 			
 			for(int i = 0; i<256; i++){
 				JCheckBox check = (JCheckBox) checkboxList.get(i);
 				if(checkboxState[i]){
 					check.setSelected(true);
 				} else {
 					check.setSelected(false);
 				}
 			}
 			
 			sequencer.stop();
 			buildTrackAndStart();
 		}
 	}
}

