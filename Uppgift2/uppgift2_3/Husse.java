package uppgift2_3;

import java.util.Scanner;

import uppgift2_1.Dog;

public class Husse {
	Dog dog = new Dog();
	Scanner scanner = new Scanner(System.in);
	private String name;	
	private int howManyDogs;
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHowManyDogs() {
		return howManyDogs;
	}

	public void setHowManyDogs(int howManyDogs) {
		this.howManyDogs = howManyDogs;
	}
	
	

}
