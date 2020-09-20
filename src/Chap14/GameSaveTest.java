package Chap14;

/**
 * 2013.04.10
 * Michel
 */
import java.io.*;
public class GameSaveTest {
	public static void main(String[] args){
		GameCharacter one = new GameCharacter(50,"ELF",new String[]{"bow","sword","dust"});
		GameCharacter two = new GameCharacter(200,"Troll",new String[]{"bare hands","big ax"});
		GameCharacter three = new GameCharacter(120,"Magician",new String[]{"spells","invisibility"});
		
		//假设此处有改变人物状态值的程序代码
		
		try{
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Game.ser"));
			os.writeObject(one);
			os.writeObject(two);
			os.writeObject(three);
		}catch(IOException ex){
			ex.printStackTrace();
		}
		one = null;
		two = null;
		three = null;
		
		try{
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("Game.ser"));
			GameCharacter oneRestore = (GameCharacter) is.readObject();
			GameCharacter twoRestore = (GameCharacter) is.readObject();
			GameCharacter threeRestore = (GameCharacter) is.readObject();
			
			System.out.println("One's type is: " + oneRestore.getType());
			System.out.println("Two's type is: " + twoRestore.getType());
			System.out.println("Three type is: " + threeRestore.getType());
		} catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
}
