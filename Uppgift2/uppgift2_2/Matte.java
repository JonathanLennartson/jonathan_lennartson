package uppgift2_2;

public class Matte {
	Cat cat = new Cat("Norry", "Norwegian wood cat");

	String name = "Ingrid";

	public String toString() {
		return "My name is " + name + " and my cat's name is " + cat.name + " and is a " + cat.race + ".";
	}
}
