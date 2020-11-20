package ovning3;

import java.util.Scanner;

public class ticTacToe {

	public static void main(String[] args) {						//H�r f�r anv�ndaren v�lja vilja
		Scanner scanner = new Scanner(System.in);					//namn som skall spela. 
		System.out.print("Spelare 1: ");							//
		String player1 = scanner.nextLine();						//
		System.out.print("Spelare 2: ");							//H�r �r spelare 2! ;P
		String player2 = scanner.nextLine();						//
			

		char[][] gameboard = { { ' ', '|', ' ', '|', ' ' }, { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' },
				{ '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' } };

		System.out.println("\nV�lkomna till Tre-i-Rad " + player1 + " och " + player2
				+ ".\nSkriv en siffra mellan 1-9 f�r att l�gga en bricka.\n");

		printGameboard(gameboard);
		playersPlacement(player1, player2, gameboard);

	}

	private static void playersPlacement(String player1, String player2, char[][] gameboard) {
		Scanner scanner = new Scanner(System.in);
		String winner = null;										//winner f� v�rde senare.
		int draw = 0;												//beroende vilket v�rde draw f�r s� blir det oavgjort.

		while (true) {
																	//H�r �r loopen f�r hela spelet som avg�r vem som vinner. 
			moves(gameboard, player1, player1, player2);			//Denna metod avg�r vem som spelar och vart man l�gger sin bricka.
			printGameboard(gameboard);								//Printar ut det nya resultatet av spelbr�dan.
			winner = checkWinner(gameboard, player1, player2);		//Metod som kollar om player1 vunnit.
			if (player1.equals(winner)) {							
				System.out.println(winner + " vann spelet!");
				break;
			}
			draw = checkDraw(gameboard);							//Metod f�r att se om det blev oavgjort. 
			if (draw == 0) {														//Om det inte finns n�gra whitespaces och 
				System.out.println("\n�sch d�, ingen vann... F�rs�k igen.");		//ingen vinst, d� �r det oavgjort.
				break;
			}

			moves(gameboard, player2, player1, player2);			//metod f�r player2.
			printGameboard(gameboard);								
			winner = checkWinner(gameboard, player1, player2);		//metod f�r att se om player2 har vunnit.
			if (player2.equals(winner)) {							//Om detta st�mmer har player2 vunnit.
				System.out.println(winner + " vann spelet!");
				break;
			}
		}
	}

	private static int checkDraw(char[][] gameboard) {				//metod f�r oavgjort.
		int symbols = 0;

		for (int i = 0; i < gameboard.length; i++) {				//kollar om raderna �r upptagna.
			for (int j = 0; j < gameboard.length; j++) {			//kollar om kolumnerna �r upptagna. 
				if (gameboard[i][j] == ' ') {
					symbols++;
				}
			}
		}

		return symbols;
	}

	private static void moves(char[][] gameboard, String user, String player1, String player2) {	//Metod f�r att l�gga sin bricka.
		Scanner scanner = new Scanner(System.in);
		char symbol = ' ';
																	//User avser vilken av player1 eller player2 som spelar. 
		if (user.equals(player1)) {									//Kolla om det �r player1 eller player2 som spelar. 
			symbol = 'x';											//Och ger 'x' eller 'o' beroende vilken spelare det �r.
		} else if (user.equals(player2)) {							//
			symbol = 'o';											//
		}

		while (true) {														//loop f�r att l�gga sin bricka. 
			int move = 0;													//loopen breakar efter varje omg�ng. 
			try {
				move = scanner.nextInt();
				
				if (move < 1 || move > 9) {									//if-sats som kollar om numret �r mer eller mindre �n 1-9,
					System.out.println("Numret m�ste vara mellan 1-9.");	//
					continue;												//om s� �r fallet b�rjar loopen om h�r.
				}

				switch (move) {
				case 1:
					if (gameboard[0][0] == 'x' || gameboard[0][0] == 'o') {					//Kollar om rutan �r upptagen.
						System.out.println("Ruta 1 �r upptagen. F�rs�k en annan siffra.");	
						continue;															//om upptagen ruta s� b�rjar loopen om h�r.
					}
					gameboard[0][0] = symbol;												//ger spelarens "symbol"-v�rde i en ruta. 
					break;
				case 2:
					if (gameboard[0][2] == 'x' || gameboard[0][2] == 'o') {
						System.out.println("Ruta 2 �r upptagen. F�rs�k en annan siffra.");
						continue;
					}
					gameboard[0][2] = symbol;
					break;
				case 3:
					if (gameboard[0][4] == 'x' || gameboard[0][4] == 'o') {
						System.out.println("Ruta 3 �r upptagen. F�rs�k en annan siffra.");
						continue;
					}
					gameboard[0][4] = symbol;
					break;
				case 4:
					if (gameboard[2][0] == 'x' || gameboard[2][0] == 'o') {
						System.out.println("Ruta 4 �r upptagen. F�rs�k en annan siffra.");
						continue;
					}
					gameboard[2][0] = symbol;
					break;
				case 5:
					if (gameboard[2][2] == 'x' || gameboard[2][2] == 'o') {
						System.out.println("Ruta 5 �r upptagen. F�rs�k en annan siffra.");
						continue;
					}
					gameboard[2][2] = symbol;
					break;
				case 6:
					if (gameboard[2][4] == 'x' || gameboard[2][4] == 'o') {
						System.out.println("Ruta 6 �r upptagen. F�rs�k en annan siffra.");
						continue;
					}
					gameboard[2][4] = symbol;
					break;
				case 7:
					if (gameboard[4][0] == 'x' || gameboard[4][0] == 'o') {
						System.out.println("Ruta 7 �r upptagen. F�rs�k en annan siffra.");
						continue;
					}
					gameboard[4][0] = symbol;
					break;
				case 8:
					if (gameboard[4][2] == 'x' || gameboard[4][2] == 'o') {
						System.out.println("Ruta 8 �r upptagen. F�rs�k en annan siffra.");
						continue;
					}
					gameboard[4][2] = symbol;
					break;
				case 9:
					if (gameboard[4][4] == 'x' || gameboard[4][4] == 'o') {
						System.out.println("Ruta 9 �r upptagen. F�rs�k en annan siffra.");
						continue;
					}
					gameboard[4][4] = symbol;
					break;
				default:
					break;
				}
				break;
			} catch (Exception InputMismatchException) {				//detta f�ngar om n�got annat �n en siffra blivit inmatad. 
				System.out.println("Det m�ste vara ett nummer!");		//printar ett felmeddelande n�r det inte �r en siffra som matats in. 
				scanner.nextLine();										//anv�ndaren f�r mata in ett nytt nummer som sedan anv�nds i spelet.
				continue;												//loopen b�rjar om h�r. 
			}
		}
	}
	
	private static String checkWinner(char[][] gameboard, String player1, String player2) { 	//metod som kollar om n�gon vunnit.
		String winner = null;

		if (gameboard[0][0] == 'x' && gameboard[0][2] == 'x' && gameboard[0][4] == 'x'			//kollar om player1 vunnit.
				|| gameboard[2][0] == 'x' && gameboard[2][2] == 'x' && gameboard[2][4] == 'x'
				|| gameboard[4][0] == 'x' && gameboard[4][2] == 'x' && gameboard[4][4] == 'x'
				|| gameboard[0][0] == 'x' && gameboard[2][0] == 'x' && gameboard[4][0] == 'x'
				|| gameboard[0][2] == 'x' && gameboard[2][2] == 'x' && gameboard[4][2] == 'x'
				|| gameboard[0][4] == 'x' && gameboard[2][4] == 'x' && gameboard[4][4] == 'x'
				|| gameboard[0][0] == 'x' && gameboard[2][2] == 'x' && gameboard[4][4] == 'x'
				|| gameboard[0][4] == 'x' && gameboard[2][2] == 'x' && gameboard[4][0] == 'x') {

			winner = player1;

		} else if (gameboard[0][0] == 'o' && gameboard[0][2] == 'o' && gameboard[0][4] == 'o'	//kollar om player2 vunnit.
				|| gameboard[2][0] == 'o' && gameboard[2][2] == 'o' && gameboard[2][4] == 'o'
				|| gameboard[4][0] == 'o' && gameboard[4][2] == 'o' && gameboard[4][4] == 'o'
				|| gameboard[0][0] == 'o' && gameboard[2][0] == 'o' && gameboard[4][0] == 'o'
				|| gameboard[0][2] == 'o' && gameboard[2][2] == 'o' && gameboard[4][2] == 'o'
				|| gameboard[0][4] == 'o' && gameboard[2][4] == 'o' && gameboard[4][4] == 'o'
				|| gameboard[0][0] == 'o' && gameboard[2][2] == 'o' && gameboard[4][4] == 'o'
				|| gameboard[0][4] == 'o' && gameboard[2][2] == 'o' && gameboard[4][0] == 'o') {

			winner = player2;
		}

		return winner;																			//returnerar v�rdet winner som 		
	}																							//player1 eller player2.

	private static void printGameboard(char[][] gameboard) {									//metod som skriver ut spelplanen 
		for (char[] row : gameboard) {															//i consolen. 
			System.out.println(row);
		}																						// SLUUUUT
	}

}
