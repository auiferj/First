package Chap12;

/**
 * 2013.04.07
 * Michel
 * 第三版:与音乐同步输出图形
 */

import javax.sound.midi.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class MiniMusicPlayer3   { 
	/**
	 * @param args
	 */
	
	static JFrame f = new JFrame("My First Music Video");
	static MyDrawPanelForPlayer3 ml;  
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		MiniMusicPlayer3 mini = new MiniMusicPlayer3();
		mini.go();
	}
	
	public void setUpGui(){
		ml = new MyDrawPanelForPlayer3();
		f.setContentPane(ml);
		f.setBounds(30,30,300,300);
		f.setVisible(true);
	}
	
	public  void go() { 
		setUpGui();
		
		try{
			//创建并打开队列
			Sequencer sequencer = MidiSystem.getSequencer(); 
			sequencer.open();
			
			//向Sequencer注册事件 
			sequencer.addControllerEventListener(ml,new int[] {127});
			
			//创建队列并track
			Sequence seq = new Sequence(Sequence.PPQ,4);
			Track track = seq.createTrack();
			
			//创建一堆连续的音符事件
			int r = 0;
			for(int i = 0;i <60;i+=4){
				
				r = (int) ((Math.random() * 50) + 1);
				track.add(makeEvent(144,1,i,100,i));
				
				//插入编号为127的自定义ControllerEvent(176),
				//它不会做任何事情，只是让我们知道音符被播放，
				//因为它的tick和NOTE ON是同时进行的
				track.add(makeEvent(176,1,127,0,i));
				
				track.add(makeEvent(128,1,i,100,i+2));
			}
			
			//开始播放
			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(120);
			sequencer.start();
			
		} catch (Exception ex) {
			
		}
	}
  
	public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick){
		MidiEvent event = null;
		try{
			ShortMessage a = new ShortMessage();
			a.setMessage(comd,chan,one,two);
			event = new MidiEvent(a,tick);
		} catch(Exception ex) {
			
		}
		return event;
	} 
}