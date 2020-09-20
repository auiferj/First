package Chap11;

/**
 * 2013.03.29
 * Michel
 * 
 * 可以使用命令列参数改变乐器和音符
 * 试试输入连个0～127之间的整数参数。
 * 第一个整数设定乐器。例如1是吉他，2是Bass...
 * 第二个整数设定音符
 */

import javax.sound.midi.*;
public class MiniMusicCmdLine {
	
	//这个类没有写从键盘接受输入的方法，所以暂时没有输入功能（切！坑我？）。
	//若想改进可以参考前面炸船游戏的输入功能。
	public static void main(String[] args) { 
		MiniMusicCmdLine mini = new MiniMusicCmdLine();
		if(args.length<2){
			System.out.println("args.length is " + args.length);
			System.out.println("Don't forget input the instrument and note args");
		} else {
			int instrument = Integer.parseInt(args[0]);
			int note = Integer.parseInt(args[0]);
			mini.play(instrument,note);
		}
	}
	
	public void play(int instrument, int note){
		try{
			
			Sequencer player = MidiSystem.getSequencer();
			player.open();
			Sequence seq = new Sequence(Sequence.PPQ,4);
			Track track = seq.createTrack();
			
			MidiEvent event = null;
			
			ShortMessage first = new ShortMessage();
			first.setMessage(192,1,instrument,0);
			MidiEvent changeInstrument = new MidiEvent(first,1);
			track.add(changeInstrument);
			
			ShortMessage a = new ShortMessage();
			a.setMessage(144,1,note,100);
			MidiEvent noteOn = new MidiEvent(a,1);
			track.add(noteOn);
			
			ShortMessage b = new ShortMessage();
			b.setMessage(128,1,note,100);
			MidiEvent noteOff = new MidiEvent(b,16);
			track.add(noteOff);
			
			player.setSequence(seq);
			player.start();
			
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
