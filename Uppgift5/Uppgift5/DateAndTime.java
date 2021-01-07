package Uppgift5;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateAndTime {
	private LocalDateTime now = LocalDateTime.now();
	private DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy-MM-dd   HH:mm:ss");
	private String dateTime;
	
	public void setDateTime() {
		this.dateTime = now.format(dft);
	}
	
	public String getDateTime() {
		return dateTime;
	}
	
}
