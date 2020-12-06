package Uppgift3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateAndTime {
	private LocalDateTime now = LocalDateTime.now();
	private DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy-MM-dd   HH:mm:ss");
	private String dateTime;
	private String stopTime;
	
	public void setDateTime() {
		this.dateTime = now.format(dft);
	}
	
	public String getDateTime() {
		return dateTime;
	}
	
	public String getStopTime() {
		return stopTime;
	}

	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}
	
	
}
