package ovning2;

public class uppgift3 {

	public static void main(String[] args) {
		int height = 8, numbers1 = 1, numbers2 = 1;

		for (int i = 1; i <= height; height--) {
			whiteSpaces(height);
			calculation1(numbers1);
			if (height <= 7) {
				calculation2(numbers1, numbers2);
			}
			System.out.println("");
			numbers1++;
			if (height <= 7) {
				numbers2 *= 3;
			}
		}
	}

	public static void calculation1(int numbersToPrint) {
		int num1 = 1;
		for (int i = 0; i < numbersToPrint; i++) {
			System.out.print(num1 + "\t");
			num1 *= 3;
		}
	}

	public static void calculation2(int numbersToPrint, int numbers) {
		for (int i = 1; i < numbersToPrint; i++) {
			System.out.print(numbers + "\t");
			numbers /= 3;
		}
	}

	public static void whiteSpaces(int white) {
		for (int i = 0; i < white; i++) {
			System.out.print("\t");
		}
	}

}