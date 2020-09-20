package Chap16;

/**
 * 2013.04.17
 * Michel
 * 加入ArrayList<Animal>
 */
import java.util.*;
public class TestGenerics2 {
	public void go(){
//		Animal[] animals = {new Dog(),new Cat(), new Dog()};
//		Dog[] dogs = {new Dog(), new Dog(), new Dog()};
//		takeAnimals(animals);
//		takeAnimals(dogs);
		
		ArrayList<Animal> animals = new ArrayList<Animal>();
		animals.add(new Dog());
		animals.add(new Cat());
		animals.add(new Dog());
		
		takeAnimals(animals);
	}
	
	public void takeAnimals(ArrayList<Animal> animals){
		for(Animal a:animals){
			a.eat();
		}
	}
	
	public static void main(String[] args){
		new TestGenerics2().go();
	}
}
