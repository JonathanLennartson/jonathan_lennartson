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
			
			AlertBox.show("Anv�nadre: " + userName + ", har skapats.\nV�nligen logga in.", "Skapad");

			XMLhandler.encode(userHashList);

			return userHashList.containsKey(userName);

		} else {
			AlertBox.show("L�senordet st�mmer inte �verens.\nF�rs�k igen.", "Fel!");
			return !userHashList.containsKey(userName);
		}

	}
}
