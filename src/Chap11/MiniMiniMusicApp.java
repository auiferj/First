package Chap11; 

/**
 * 2013.03.29
 * Michel
 * (自称)史上第一个声音播放程序，哈哈
 */

import javax.sound.midi.*; 
public class MiniMiniMusicApp {
	
	public static void main(String[] args){
		MiniMiniMusicApp mini = new MiniMiniMusicApp();
		mini.play();
	}
	
	public void play(){
		
		try{
			//创建Sequencer
			Sequencer player = MidiSystem.getSequencer();
			player.open();
			
			//创建新的Sequence
			Sequence seq = new Sequence(Sequence.PPQ,4);
			
			//从Sequence中创建新的Track
			Track track = seq.createTrack();
			
			//填入MidiEvent并让Sequencer播放
			ShortMessage a = new ShortMessage();
			a.setMessage(144,1,44,100);          //44音符  （具体参见API javax.sound.midi.MidiMessage）
			MidiEvent noteOn = new MidiEvent(a,1); //在第一拍启动a
			track.add(noteOn);
			
			ShortMessage b = new ShortMessage();
			b.setMessage(128,1,44,100);
			MidiEvent noteOff = new MidiEvent(b,16);
			track.add(noteOff);
			 
			player.setSequence(seq); //将Sequence送到Sequencer上
			
			//play
			player.start();
			 
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
