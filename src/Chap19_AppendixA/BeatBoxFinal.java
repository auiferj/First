package Chap19_AppendixA;

/**
 * 2013.04.22
 * BeatBox最终版（客户端） 
 * 新增部分：
 * GUI：加入了两个新的组件来显示收到的信息
 * 网络：BeatBox会连接到服务器取得输出入串流
 * 线程：reader这个类会持续地从服务器读取信息
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
 * 先运行服务器端：MusicServer.java， 再运行BeatBoxFinal.java
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
 */
import java.awt.*;

import javax.swing.*;

import java.io.*;

import javax.sound.midi.*;

import java.util.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.event.*;

import Chap14.BeatBox.MyDownTempoListener;
import Chap14.BeatBox.MyReadInListener;
import Chap14.BeatBox.MySendListener;
import Chap14.BeatBox.MyStartListener;
import Chap14.BeatBox.MyStopListener;
import Chap14.BeatBox.MyUpTempoListener;

public class BeatBoxFinal {
	
	JFrame theFrame;
	JPanel mainPanel;
	JList incomingList;
	JTextField userMessage;
	ArrayList<JCheckBox> checkboxList;
	int nextNum;
	Vector<String> listVector = new Vector<String>();
	String userName;
	ObjectOutputStream out;
	ObjectInputStream in;
	HashMap<String,boolean[]> otherSeqsMap = new HashMap<String,boolean[]>();
	
	Sequencer sequencer;
	Sequence sequence;
	Sequence mySequence = null;
	Track track;
	
	//乐器的名称，以String的array维护
	String[] instrumentNames = {"Bass Drum","Closed Hi-Hat",
		"Open Hi-Hat","Acoustic Snare","Crash Cymbal","Hand Clap",
		"High Tom","Hi Bongo","Maracas","Whistle","Low Conga",
		"Cowbell","Vibraslap","Low-mid Tom","High Agogo",
		"Open Hi Conga"};
	
	//实际的乐器关键字，例如35是bass，42是Closed Hi-Hat
	int[] instruments = {35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};
	
	public static void main(String[] args){
		//作为显示名称的命令栏参数，
		//例如：%java BeatBoxFinal theFlash
		//new BeatBoxFinal().startUp(args[0]);  //args[0] is your ID/screen name
		new BeatBoxFinal().startUp("Michel");
	}
	
	public void startUp(String name){
		userName = name;
		//open connection to server
		try{
			Socket sock = new Socket("127.0.0.1", 4242);
			out = new ObjectOutputStream(sock.getOutputStream());
			in = new ObjectInputStream(sock.getInputStream());
			Thread remote = new Thread(new RemoteReader());
			remote.start();
		}catch(Exception ex){
			System.out.println("couldn't connect - you'll have to play alone.");
		}
		setUpMidi();
		buildGUI();
	}
	
	public void buildGUI(){
		theFrame = new JFrame("Cyber BeatBox"); 
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
 		
 		JButton sendIt = new JButton("sendIt");
 		sendIt.addActionListener(new MySendListener());
 		buttonBox.add(sendIt);
 		
 		userMessage = new JTextField();
 		buttonBox.add(userMessage);
 		
 		//会显示收到的信息的组件
 		incomingList = new JList();
 		incomingList.addListSelectionListener(new MyListSelectionListener());
 		incomingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 		JScrollPane theList = new JScrollPane(incomingList);
 		buttonBox.add(theList);
 		incomingList.setListData(listVector); // no data to start with
 		
 		
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
 		background.add(BorderLayout.CENTER, mainPanel);
 		
 		//创建checkbox组，设定成未勾选。并加入到ArrayList和面板上
 		for(int i = 0;i < 256; i++){
 			JCheckBox c = new JCheckBox();
 			c.setSelected(false);
 			checkboxList.add(c);
 			mainPanel.add(c);
 		} 
 		
 		theFrame.setBounds(50,50,300,300);
 		theFrame.pack();
 		theFrame.setVisible(true);
	}
	
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
	
	public void buildTrackAndStart(){
		ArrayList<Integer> trackList = null;
 		
 		//清除掉旧的track做一个新的
 		sequence.deleteTrack(track);
 		track = sequence.createTrack();
 		
 		//对每个乐器都执行一次
 		for(int i = 0; i<16; i++){
 			trackList = new ArrayList<Integer>();
 			 
 	 		//对每一拍执行一次
 	 		for(int j=0; j<16; j++){
 	 			JCheckBox jc = (JCheckBox) checkboxList.get(j+(16*i));
 	 			if(jc.isSelected()){
 	 			//设定代表乐器的关键字
 	 	 	 		int key = instruments[i];
 	 				trackList.add(new Integer(key));
 	 			} else {
 	 				trackList.add(null);
 	 			}
 	 		}
 	 		
 	 		//创建此乐器的事件并加到track上
 	 		makeTracks(trackList); 
 	 		//track.add(makeEvent(176,1,127,0,16));
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
	
	public class MyStartListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent a) {
			// TODO Auto-generated method stub
			buildTrackAndStart();
		}
	}
	
	public class MyStopListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent a) {
			// TODO Auto-generated method stub
			sequencer.stop();
		}
	}
	
	public class MyUpTempoListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent a) {
			// TODO Auto-generated method stub
			float tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float)(tempoFactor * 1.03));
		}
	}
	
	public class MyDownTempoListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent a) {
			// TODO Auto-generated method stub
			float tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float) (tempoFactor * 0.97));
		}
	}
	
	public class MySendListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent a) {
			// make an arraylist of just the STATE of the checkboxes
			boolean[] checkboxState = new boolean[256];
 			for(int i = 0; i<256; i++){
 				JCheckBox check = (JCheckBox) checkboxList.get(i);
 				if(check.isSelected()){
 					checkboxState[i] = true;
 				}
 			}
 			String  messageToSend = null;
 	 		try {
 	 			out.writeObject(userName + nextNum + ": " + userMessage.getText());
 	 			out.writeObject(checkboxState);
 	 		} catch(Exception ex){
 	 			System.out.println("Sorry dude. Could not send it to the server.");
 	 		}
 	 		userMessage.setText("");
		}
	}
	
	public class MyListSelectionListener implements ListSelectionListener{
		@Override
		public void valueChanged(ListSelectionEvent le) {
			// TODO Auto-generated method stub
			if(!le.getValueIsAdjusting()){
				String selected = (String) incomingList.getSelectedValue();
				if(selected!=null){
					//now go to the map, and change the sequence
					boolean[] selectedState = (boolean[]) otherSeqsMap.get(selected);
					changeSequence(selectedState);
					sequencer.stop();
					buildTrackAndStart();
				}
			}
		}
	}
	
	public class RemoteReader implements Runnable{
		boolean[] checkboxState = null;
		String nameToShow = null;
		Object obj = null;
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try{
				while((obj=in.readObject())!=null){
					System.out.println("got an object from server");
					System.out.println(obj.getClass());
					String nameToShow = (String) obj;
					checkboxState = (boolean[]) in.readObject();
					otherSeqsMap.put(nameToShow, checkboxState);
					listVector.add(nameToShow);
					incomingList.setListData(listVector);
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}	
	}
	
	public class MyPlayMineListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent a) {
			// TODO Auto-generated method stub
			if(mySequence != null){
				sequence = mySequence;  //restore to my original
			}
		}
	}
	
	public void changeSequence(boolean[] checkboxState){
		for(int i=0; i<256; i++){
			JCheckBox check = (JCheckBox) checkboxList.get(i);
			if(checkboxState[i]){
				check.setSelected(true);
			} else {
				check.setSelected(false);
			}
		}
	}
	
	public void makeTracks(ArrayList list){
		Iterator it = list.iterator();
		for(int i=0; i<16;i++){
			Integer num = (Integer) it.next();
			if(num != null){ 
				int numKey = num.intValue();
				track.add(makeEvent(144,9,numKey,100,i));
				track.add(makeEvent(128,9,numKey,100,i+1));
			}
		}
	}
	
	public MidiEvent makeEvent(int comd, int chan, int one ,int two, int tick){
		MidiEvent event = null;
		try{
			ShortMessage a = new ShortMessage();
			a.setMessage(comd,chan,one,two);
			event = new MidiEvent(a,tick);
		}catch(Exception e){
			return event;
		}
		return event;
	}
} 