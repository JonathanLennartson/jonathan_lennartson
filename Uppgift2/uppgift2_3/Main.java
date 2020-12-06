package uppgift2_3;

import uppgift2_1.Dog;

public class Main {

	public static void main(String[] args) {
		Husse husse = new Husse();
		Dog dog = new Dog();

		husse.setName("Matti");
		husse.setHowManyDogs(4);

		String[] dogList = new String[husse.getHowManyDogs()];

		dogList[0] = dog.setName("Bonzo");
		dogList[1] = dog.setName("Kalle");
		dogList[2] = dog.setName("Gaya");
		dogList[3] = dog.setName("Faya");

		System.out.println("Jag heter " + husse.getName() + " och har " + husse.getHowManyDogs() + " hundar som heter "
				+ dogList[0] + ", " + dogList[1] + ", " + dogList[2] + " och " + dogList[3] + ".");

	}
}