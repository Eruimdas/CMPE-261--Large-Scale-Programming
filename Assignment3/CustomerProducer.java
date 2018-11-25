import java.util.ArrayList;
import java.util.Random;

public class CustomerProducer extends Thread {
	private Timer timer;
	private Time custoTime;
	private ProductList plist;
	private Random rand = new Random();
	private int number = 1;
	private ArrayList<Cashier> cashlist = new ArrayList<Cashier>();
	
	
	// Creating a thread to create customer to arrive between periods of 2 min and 15 min
	// after the timer's time passed 9.
	public CustomerProducer(Timer timer, ProductList plist, ArrayList<Cashier> mycash) {
		this.timer = timer;
		this.plist = plist;
		cashlist = mycash;
	}

	public void run() {
		while (timer.getTime().getH() < 9) {
			try {
				Thread.currentThread().sleep(1);
			} catch (InterruptedException e) {
			}
		}

		while (timer.getTime().getH() >= 9 && timer.getTime().getH() < 17) {
			int xsec = rand.nextInt(780) + 120;
			try {
				breakWait(xsec);
				new Customer(plist, timer, number, cashlist);
				number++;
			} catch (InterruptedException e) {
			}

		}
	}

	public void breakWait(int sec) throws InterruptedException {

		custoTime = timer.getTime();
		custoTime.increase(sec);

		while (!custoTime.equals(timer.getTime())) {
			Thread.currentThread().sleep(1);
		}

	}

}
