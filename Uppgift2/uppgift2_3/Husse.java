package uppgift2_3;

public class Husse {
	String name = "Matti";
	
	Dog Bonzo = new Dog("Bonzo", "Terverense");
	Dog Stina = new Dog("Stina", "Labrador");
	Dog Nova = new Dog("Nova", "German shepherd");
	
	public String toString() {
		return "Jag heter " + name + " och har tre hundar som heter " + Bonzo.name + ", " + Stina.name + " och " + Nova.name + ".";
	}
}
