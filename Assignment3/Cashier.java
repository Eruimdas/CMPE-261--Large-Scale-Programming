import java.util.ArrayList;
import java.util.Random;

public class Cashier extends Thread {
	private Timer timer;
	private Time customerTime = new Time(), custoTime;
	public ArrayList<Customer> thequeue;
	private Customer come;
	private int time = 0;
	private Random rand = new Random();

	public Cashier(Timer timer) {
		thequeue = new ArrayList<Customer>();
		this.timer = timer;
	}

	// Adding a customer to the cashier's queue. And prints the time customer
	// entered.
	public void addCustomer(Customer c) {
		try {
			thequeue.add(c);
			come = c;
			System.out.println(
					"Customer" + come.getCName() + " entered queue" + this.getName() + " at: " + timer.humanTime());

		} catch (Exception e) {
		}
	}

	// Removes customer from queue.
	private void removeCustomer() {
		come = thequeue.get(0);
		thequeue.remove(0);
	}

	// while the queue is not empty, cashier works until the time is 5pm(17)
	// (this process is controlled through Supermarket Class' main method)
	// while processing the queue, gives the wanted properties.
	public void run() {
		while (!thequeue.isEmpty()) {
			try {
				removeCustomer();
				System.out.println("Customer" + come.getCName() + "'s items processed within "
						+ translateHuman(come.getQuantity()));
				breakWait(come.getQuantity());
				System.out.println("Customer" + come.getCName() + " paid: " + come.getSum() + "$" + " and left: "
						+ timer.humanTime());
			} catch (Exception e) {
				System.out.println("cashier error");
			}
		}

	}

	// this method calculates the queues time for cashier.
	public int calculateTime() {
		time = 0;
		for (int i = 0; i < thequeue.size(); i++) {
			time += thequeue.get(i).getQuantity();
		}
		return time;
	}

	// this method waits until determined time has passed for a customer
	private void breakWait(int sec) throws InterruptedException {

		customerTime = timer.getTime();
		customerTime.increase(sec);

		while (!customerTime.equals(timer.getTime())) {
			Thread.currentThread().sleep(1);
		}

	}

	// gives the process time of a customer as xx minutes and xx seconds, h is
	// unnecessary.
	private String translateHuman(int s) {
		int m = 0;
		while (s >= 60) {
			m %= 60;
			s /= 60;
			while (m >= 60) {
				m /= 60;
			}
		}
		String s2 = " " + m + " minutes " + s + " seconds.";

		return s2;
	}

	// printing the queue, in order to make sure it's empty. to be controlled by the
	// user of the program.
	public void printQueue() {
		System.out.print("{[");
		for (int i = 0; i < thequeue.size(); i++) {
			System.out.print(thequeue.get(i));
		}
		System.out.print("]}\n");
	}

}
