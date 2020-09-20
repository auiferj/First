package Chap16;

/**
 * 2013.04.17
 * Michel
 */
public class TestGenerics1 {
	public void go(){
		Animal[] animals = {new Dog(),new Cat(), new Dog()};
		Dog[] dogs = {new Dog(), new Dog(), new Dog()};
		takeAnimals(animals);
		takeAnimals(dogs);
	}
	
	public void takeAnimals(Animal[] animals){
		for(Animal a:animals){
			a.eat();
		}
	}
	
	public static void main(String[] args){
		new TestGenerics1().go();
	}
}
