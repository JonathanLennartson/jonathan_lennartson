package Uppgift5;

import java.util.HashMap;

public class NewPasswordMethod {
static String message;
	
	public static Boolean newPassword(String userName, String password, String currentPassword, String newPassword, String repeatNewPassword) {
		HashMap<String, Account> userHashList = new HashMap<String, Account>();
		Account account = new Account();
		XMLhandler.decode();
		
		userHashList = XMLhandler.list; 
		account = userHashList.get(userName);
		
		if (currentPassword.equals(password) && newPassword.equals(repeatNewPassword)) {
			
			userHashList.remove(userName, account);
			
			account.setPassword(newPassword);			
			userHashList.putIfAbsent(userName, account);
			System.out.println(userHashList);		
			
			message = "Du har bytt lösenord.";
			AlertBox.show(message, "Skapad");			
					
			XMLhandler.encode(userHashList);
			
			return userHashList.containsKey(userName); 
		
		} else { 
			
			message = "Lösenordet stämmer inte överens.\n"
					+ "Försök igen.";
			AlertBox.show(message, "Fel!");			
						
			return !userHashList.containsKey(userName);
		}
		
		
	}

}
