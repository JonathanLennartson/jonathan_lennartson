package uppgift2_1;

public class Main {

	public static void main(String[] args) {
		Cat norry = new Cat("cat", "Norweigan wood cat", "Norry");
		Dog gerry = new Dog("dog", "German shepherd", "Gerry");
		
		System.out.println("The dogs race is: " + gerry.race + ",\nand it's name is: " + gerry.name + ".\n");
		System.out.println("The cats race is: " + norry.race + ",\nand it's name is: " + norry.name + ".");
	}

}
