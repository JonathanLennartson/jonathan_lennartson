package Uppgift5;

import java.util.HashMap;

public class NewAccountMethod {

	static String message;

	public static Boolean NewUser(String userName, String password, String repeatPassword) {
		HashMap<String, Account> userHashList = new HashMap<String, Account>();
		Account account = new Account();		
		
		XMLhandler.decode();
		
		userHashList = XMLhandler.list;

		if (password.equals(repeatPassword)) {
		
			account.setPassword(password);
			
			userHashList.putIfAbsent(userName, account);
			
			AlertBox.show("Använadre: " + userName + ", har skapats.\nVänligen logga in.", "Skapad");

			XMLhandler.encode(userHashList);

			return userHashList.containsKey(userName);

		} else {
			AlertBox.show("Lösenordet stämmer inte överens.\nFörsök igen.", "Fel!");
			return !userHashList.containsKey(userName);
		}

	}
}
