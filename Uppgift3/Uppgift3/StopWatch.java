package Uppgift3;

import java.util.Scanner;

public class StopWatch extends Thread {
	private Scanner scanner = new Scanner(System.in);
	private volatile boolean counting = true;
	private int minute = 0;
	private int seconds = 0;
	private int miliSeconds = 0;

	public void run() {
		while (counting) {
			System.out.println(minute + ":" + seconds + "," + miliSeconds);
			miliSeconds++;
			if (miliSeconds == 1000) {
				miliSeconds = 000;
				seconds++;
			}
			else if (seconds == 60) {
				seconds = 0;
				minute ++;
				
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void stopCounting() {		
		counting = false;
		System.out.println("Stop");
	}
}
