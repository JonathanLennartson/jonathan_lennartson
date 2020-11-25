package uppgift2_4;

public class Cat {
	
	final String name = "Norry";
	final String race = "Norwegian wood cat";

	public static String whosOwner() {		
		Matte owner = new Matte();
		return "My owner is " + owner.name + ".";
	}

}
