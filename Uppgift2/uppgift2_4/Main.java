package uppgift2_4;

public class Main {

	public static void main(String[] args) {
		Matte matte = new Matte();
		Cat cat = new Cat();	
		
		System.out.println(matte.toString());
		
		System.out.println("Hey cat, whos your owner?");
		System.out.println(cat.whosOwner());
	}

}
