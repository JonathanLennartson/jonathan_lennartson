package uppgift2_4;

public class Matte {
	Cat cat = new Cat();
	String name = "Ingrid";

	public String toString() {
		return "My name is " + name + " and my cat's name is " + cat.name + " and he's a " + cat.race + ".";
	}
}
