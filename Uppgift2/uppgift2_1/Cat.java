package uppgift2_1;

public class Cat extends Animal {	
	String race;
	String name;
	
	Cat (String type, String race, String name) {
		super (type);
		this.race = race;
		this.name = name;
	}
}
