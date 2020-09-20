package Chap16;

/**
 * 2013.04.17
 * Michel
 * 加入ArrayList<Dog>
 */
import java.util.ArrayList;
public class TestGenerics3 {
	public void go(){
//		Animal[] animals = {new Dog(),new Cat(), new Dog()};
//		Dog[] dogs = {new Dog(), new Dog(), new Dog()};
//		takeAnimals(animals);
//		takeAnimals(dogs);

		ArrayList<Dog> dogs = new ArrayList<Dog>();
		dogs.add(new Dog());
		dogs.add(new Dog());	
		dogs.add(new Dog());

		takeAnimals(dogs);
	}
	
	//使用万用字符  ? extends XXX
	//此处的extends同时代表继承类和实现接口 
	public void takeAnimals(ArrayList<? extends Animal> animals){
		for(Animal a:animals){
			a.eat();
		}
	}
	//另外一种写法
	public <T extends Animal> void takeAnimals2(ArrayList<T> animals){
		//略
	}
	
	public static void main(String[] args){
		new TestGenerics3().go();
	}
}