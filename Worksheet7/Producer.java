package worksheet_7;

import java.util.Random;

public class Producer extends Thread {
	private addInt myint;
	private Random rand;

	public Producer(addInt s) {
		this.myint = s;
		rand = new Random();
	}

	public void run() {
		while (true) {
			myint.addMyInt(this);
			try {
				Thread.currentThread().sleep(rand.nextInt(600) + 200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			}
		}
	}

}
