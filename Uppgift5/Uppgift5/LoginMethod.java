package Uppgift5;

import java.util.HashMap;

public class LoginMethod {

	public static Boolean login(String userName, String password) {
		HashMap<String, Account> userHashList = new HashMap<String, Account>();
				
		XMLhandler.decode();
		
		if (XMLhandler.decoder == null) {
			return false;
		}	
		
		userHashList = XMLhandler.list;
		
		if (password.equals(userHashList.get(userName).getPassword())) {
			return true;
		} else {
			return false;
		}
	}
}
