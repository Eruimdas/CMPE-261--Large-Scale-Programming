package worksheet_7;

import java.util.Random;

public class Consumer extends Thread {
	private Random rand;
	private addInt myint;

	public Consumer(addInt s) {
		this.myint = s;
		rand = new Random();
	}

	public void run() {
		while (true) {
			myint.deleteMyInt(this);
			try {
				Thread.currentThread().sleep(rand.nextInt(1200) + 200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			}
		}

	}

}
