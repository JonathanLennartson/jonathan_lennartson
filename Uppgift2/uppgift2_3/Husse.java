package uppgift2_3;

import java.util.ArrayList;
import java.util.Scanner;

public class Husse {
	Scanner scanner = new Scanner(System.in);
	ArrayList<Dog> list = new ArrayList<Dog>();

	String name;
	int dogs;

	public void name() {
		System.out.println("Vad heter matte?");
		this.name = scanner.nextLine();
	}

	public void howManyDogs() {
		System.out.println("Hur många hundar " + name + "?");
		this.dogs = scanner.nextInt();
	}

	public void dogList() {
		System.out.println("Vad heter hundarna?");
		Dog dog = new Dog();
		for (int i = 0; i < dogs; i++) {
			dog.setName(scanner.nextLine());
			list.add(i, dog);
		}

	}

	public String toString() {
		return "Jag heter " + name + " och har " + dogs + " hundar som heter " + list;
	}

}
