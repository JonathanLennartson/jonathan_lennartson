package uppgift2_1;

public class Main {

	public static void main(String[] args) {
		Cat norry = new Cat();
		Dog gerry = new Dog();
		
		norry.setName("Norry");
		norry.setRace("Norwegian wood cat");
		gerry.setName("Gerry");
		gerry.setRace("German Shepherd");
		
		
		System.out.println("The dogs race is: " + gerry.getRace() + ",\nand it's name is: " + gerry.getName() + ".\n");
		System.out.println("The cats race is: " + norry.getRace() + ",\nand it's name is: " + norry.getName() + ".");
	}

}
