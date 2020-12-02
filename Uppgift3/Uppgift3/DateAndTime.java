package Uppgift3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateAndTime {
	private LocalDateTime now = LocalDateTime.now();
	private DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm:ss");
	
	public void getDateAndTime() {
		System.out.println(dft.format(now));
	}
	
	
}
