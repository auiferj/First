package Chap12;

/**
 * 2013.04.07
 * Michel
 * 范例：如何使用静态的makeEvent()方法
 */

import javax.sound.midi.*;
public class MiniMusicPlayer1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		try{
			//创建并打开队列
			Sequencer sequencer = MidiSystem.getSequencer(); 
			sequencer.open();
			
			//创建队列并track
			Sequence seq = new Sequence(Sequence.PPQ,4);
			Track track = seq.createTrack();
			
			//创建一堆连续的音符事件
			for(int i = 5;i <61;i+=4){
				track.add(makeEvent(144,1,i,100,i));
				track.add(makeEvent(128,1,i,100,i+2));
			}
			
			//开始播放
			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(200);
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
