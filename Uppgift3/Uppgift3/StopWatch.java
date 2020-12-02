package Uppgift3;

public class StopWatch extends Thread {
	private volatile boolean counting = true;
	private int minute = 0;
	private int seconds = 0;
	private int milliSeconds = 0;
	String stopTime;

	public void run() {
		while (counting) {
			System.out.println(minute + ":" + seconds + "," + milliSeconds);
			milliSeconds++;
			if (milliSeconds == 1000) {
				milliSeconds = 000;
				seconds++;
			} else if (seconds == 60) {
				seconds = 0;
				minute++;
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			stopTime = stopTime.valueOf(minute + ":" + seconds + "," + milliSeconds);
		}
	}

	public void stopCounting() {
		counting = false;
		System.out.println("Stop");
	}
}
