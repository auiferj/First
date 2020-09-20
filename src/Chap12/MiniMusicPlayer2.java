package Chap12;

/**
 * 2013.04.07
 * Michel
 * 第二版:注册并取得ControllerEvent方法
 */

import javax.sound.midi.*;
public class MiniMusicPlayer2 implements ControllerEventListener {
	//实现ControllerEventListener接口，用来监听ControllerEvent
	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		MiniMusicPlayer2 mini = new MiniMusicPlayer2();
		mini.go();
	}
	
	public  void go() { 
		try{
			//创建并打开队列
			Sequencer sequencer = MidiSystem.getSequencer(); 
			sequencer.open();
			
			//向Sequencer注册事件
			int[] eventsIWant = {127};
			sequencer.addControllerEventListener(this,eventsIWant);
			
			//创建队列并track
			Sequence seq = new Sequence(Sequence.PPQ,4);
			Track track = seq.createTrack();
			
			//创建一堆连续的音符事件
			for(int i = 5;i <61;i+=4){
				track.add(makeEvent(144,1,i,100,i));
				
				//插入编号为127的自定义ControllerEvent(176),
				//它不会做任何事情，只是让我们知道音符被播放，
				//因为它的tick和NOTE ON是同时进行的
				track.add(makeEvent(176,1,127,0,i));
				
				track.add(makeEvent(128,1,i,100,i+2));
			}
			
			//开始播放
			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(220);
			sequencer.start();
			
		} catch (Exception ex) {
			
		}
	}
	
	//获知事件时在命令打印出字符串的事件处理程序
	public void controlChange(ShortMessage event){
		System.out.print("la");
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

