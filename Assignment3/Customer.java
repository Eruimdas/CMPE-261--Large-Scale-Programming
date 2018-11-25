import java.util.ArrayList;
import java.util.Random;

public class Customer extends Thread {
	private Timer timer;
	private Random rand = new Random();
	private int howmany, sum = 0, quantity = 0, name;
	private ProductList p;
	private ArrayList<Cashier> cashlist = new ArrayList<Cashier>();
	private int[] times;
	private Time time;

	// creating a Customer, joining it for proper output.
	public Customer(ProductList product, Timer timer, int x, ArrayList<Cashier> mycash) {
		p = product;
		this.timer = timer;
		name = x;
		cashlist = mycash;
		this.setName(Integer.toString(x));
		this.start();
		try {
			this.join();
		} catch (Exception e) {

		}
	}

	// Determining how many things customer will get, how much will it pay, and then
	// determining how much time did s/he spent while choosing the products
	// and waiting that time before entering a cashier queue.
	public void run() {
		System.out.println("Customer" + this.getName() + " entered at " + timer.humanTime());
		howmany = rand.nextInt(20) + 1;
		for (int i = 0; i < howmany; i++) {
			int y = rand.nextInt(1000) + 1;
			int x = rand.nextInt(5) + 1;
			quantity += x;
			sum += p.pri(y) * x;
		}
		int wait = rand.nextInt(1680) + 120;
		time = timer.getTime();
		time.increase(wait);
		while (!time.equals(timer.getTime())) {
			try {
				Thread.currentThread().sleep(1);
			} catch (InterruptedException e) {
			}
		}
		enterQueue();
	}

	public int getHowMany() {
		return howmany;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getSum() {
		return sum;
	}

	public String getCName() {
		return this.getName();
	}

	// EnterQueue has two subsections:
	// If the customer is odd numbered, s/he will decide to join a queue by
	// calculating
	// remaining times of all queues.
	// If the customer is even numbered, s/he will decide to join a queue by random.
	private void enterQueue() {
		if (name % 2 == 0) {
			calculateCashiers();
			int y = rand.nextInt(3);
			timer.addTimeRandom(times[y]);
			System.out
					.println("Customer" + this.getCName() + " will wait on queue" + (y + 1) + translateHuman(times[y]));
			cashlist.get(y).addCustomer(this);
		} else {
			calculateCashiers();
			int y = getMinIndex();
			timer.addTimeCalc(times[y]);
			System.out
					.println("Customer" + this.getCName() + " will wait on queue" + (y + 1) + translateHuman(times[y]));
			cashlist.get(y).addCustomer(this);
		}
	}

	// getting the queue times of all cashiers.
	private void calculateCashiers() {
		times = new int[3];
		for (int i = 0; i < cashlist.size(); i++) {
			times[i] = cashlist.get(i).calculateTime();
		}
	}

	// determining the least waiting queue.
	private int getMinIndex() {
		calculateCashiers();
		int times2 = times[0];
		int index = 0;
		for (int i = 1; i < times.length; i++) {
			if (times[i] < times2) {
				index = i;
				times2 = times[i];
			}
		}
		return index;
	}

	private String translateHuman(int s) {
		int m = 0, h = 0;
		if (s >= 60) {
			m++;
			s = s % 60;
		}
		String s2 = " " + m + " minutes " + s + " seconds.";

		return s2;
	}

}
