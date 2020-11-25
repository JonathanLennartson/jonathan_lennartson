package uppgift2_1;

public class Dog extends Animal {
	String race;
	String name;
	
		Dog (String type, String race, String name) {
			super (type);
			this.race = race;
			this.name = name;
		}
		
		public void getName(String name) {
			this.name = name;
		}
}
